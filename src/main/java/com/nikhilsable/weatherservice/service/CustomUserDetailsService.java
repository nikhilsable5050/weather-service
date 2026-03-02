package com.nikhilsable.weatherservice.service;

import com.nikhilsable.weatherservice.entity.Users;
import com.nikhilsable.weatherservice.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    public CustomUserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }
    public Users saveUser(Users user) {
        return userDetailsRepository.save(user);
    }
}
