package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setRole("MARKETER");
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElse(null);
    }
}
