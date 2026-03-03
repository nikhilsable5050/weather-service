package com.nikhilsable.weatherservice.config;

import org.springframework.context.annotation.Bean;          // Used to create Spring beans
import org.springframework.context.annotation.Configuration; // Marks this class as configuration

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCrypt hashing
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration   // Tells Spring this class contains security configuration
public class SecurityConfig {

    // 🔐 This method defines how HTTP security should behave
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // ❌ Disable CSRF (for REST APIs & Postman testing)
                // CSRF is mainly needed for browser form submissions
                .csrf(csrf -> csrf.disable())

                // 🔑 Define authorization rules (who can access what)
                .authorizeHttpRequests(auth -> auth

                        // ✅ Allow anyone to access /users and its subpaths
                        // Used for registration endpoint
                        .requestMatchers("/users/**").permitAll()

                        // 🔒 All other endpoints require authentication
                        .anyRequest().authenticated()
                )

                // 🔐 Enable Basic Authentication
                // Username + Password will be sent in Authorization header
                .httpBasic(Customizer.withDefaults());

        // Build and return the security configuration
        return http.build();
    }

    // 🔑 Password Encoder Bean
    // Spring will use this to hash passwords before saving
    // and to compare passwords during login
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Industry standard hashing algorithm
    }
}