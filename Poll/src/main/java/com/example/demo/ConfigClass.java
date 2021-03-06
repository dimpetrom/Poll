package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigClass {

    // This needs an additional dependecy https://mvnrepository.com/artifact/org.mindrot/jbcrypt
    // BCryptPasswordEncoder: BCrypt algorithm generates a String of length 60.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
