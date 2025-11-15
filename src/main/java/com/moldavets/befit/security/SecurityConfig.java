package com.moldavets.befit.security;

import com.moldavets.befit.config.SecurityProperties;
import com.moldavets.befit.model.entity.AppUserEntity;
import com.moldavets.befit.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AppUserRepository appUserRepository;
    private final SecurityProperties securityProperties;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(securityProperties.getPath().getAllowed()).permitAll()
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .defaultSuccessUrl("/")
                        .permitAll()
        ).logout(logout -> logout.permitAll().logoutSuccessUrl("/login?logout")
        ).exceptionHandling(
                configurer ->
                        configurer.accessDeniedPage("/access-denied")
        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> appUserRepository.findByUsername(username)
                .map(user -> User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole().replace("ROLE_", ""))
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner initAdminUser() {
        return args -> {
            if (appUserRepository.findByUsername("admin").isEmpty()) {
                var adminUser = new AppUserEntity();
                adminUser.setUsername(securityProperties.getAdmin().getLogin());
                adminUser.setPassword(passwordEncoder().encode(securityProperties.getAdmin().getPassword()));
                adminUser.setRole("ROLE_ADMIN");
                appUserRepository.save(adminUser);
            }
        };
    }
}
