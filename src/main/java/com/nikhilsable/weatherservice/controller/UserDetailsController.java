package com.nikhilsable.weatherservice.controller;

import com.nikhilsable.weatherservice.entity.Users;
import com.nikhilsable.weatherservice.service.CustomUserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    private final CustomUserDetailsService customUserDetailsService;

    public UserDetailsController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return customUserDetailsService.saveUser(user);
    }
}