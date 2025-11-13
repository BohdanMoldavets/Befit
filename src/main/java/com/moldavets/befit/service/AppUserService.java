package com.moldavets.befit.service;

import com.moldavets.befit.model.entity.AppUserEntity;
import com.moldavets.befit.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        if (appUserRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists!");
        }
        AppUserEntity user = AppUserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role("ROLE_USER")
                .build();
        appUserRepository.save(user);
    }

}
