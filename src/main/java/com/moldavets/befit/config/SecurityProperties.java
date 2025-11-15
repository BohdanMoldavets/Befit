package com.moldavets.befit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "features.security")
public class SecurityProperties {

    private Admin admin;
    private Path path;

    @Data
    public static class Admin {
        public String login;
        public String password;
    }

    @Data
    public static class Path {
        public String[] allowed;
    }

}
