package com.nikhilsable.weatherservice.service;

import com.nikhilsable.weatherservice.entity.Users;
import com.nikhilsable.weatherservice.repository.UserDetailsRepository;

import org.springframework.security.core.userdetails.User; // Spring Security User
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // IMPORTANT
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection (Best Practice)
    public CustomUserDetailsService(UserDetailsRepository userDetailsRepository,
                                    PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 🔐 This method is used during LOGIN
    // Spring Security automatically calls this method
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Fetch user from database
        Users user = userDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return Spring Security User object
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Already encoded password from DB
                .roles("USER") // You can change if you have role column
                .build();
    }


    // 🔐 This method is used during REGISTRATION
    public Users saveUser(Users user) {

        // Encode password BEFORE saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save encoded password in DB
        return userDetailsRepository.save(user);
    }
}