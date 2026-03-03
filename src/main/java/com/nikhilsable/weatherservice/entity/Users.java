package com.nikhilsable.weatherservice.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                      // Marks this class as a JPA Entity
@Table(name = "users")       // Table name in database
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto-increment primary key
    private Long id;

    @Column(nullable = false, unique = true)
    // Username cannot be null and must be unique
    private String username;

    @Column(nullable = false)
    // Encoded password will be stored here
    private String password;

    @Column(nullable = false)
    // Role like USER or ADMIN
    private String role;
}