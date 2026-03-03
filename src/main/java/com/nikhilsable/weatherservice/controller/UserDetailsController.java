package com.nikhilsable.weatherservice.controller;

import com.nikhilsable.weatherservice.entity.Users;
import com.nikhilsable.weatherservice.service.CustomUserDetailsService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    private final CustomUserDetailsService customUserDetailsService;

    // Constructor injection
    public UserDetailsController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    // 🔐 Register new user
    @PostMapping
    public String createUser(@RequestBody Users user) {

        // Call service to save user (password will be encoded there)
        customUserDetailsService.saveUser(user);

        // Do NOT return password back to client
        return "User registered successfully";
    }
}