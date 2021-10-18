package com.example.tomcattest.servise;

import com.example.tomcattest.configurations.SecurityUtils;
import com.example.tomcattest.model.User;
import com.example.tomcattest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getCurrentUser() {
        return userRepository.findByUsername(SecurityUtils.getAuthentication().getUsername());
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
