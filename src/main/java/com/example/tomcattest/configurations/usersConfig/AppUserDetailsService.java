package com.example.tomcattest.configurations.usersConfig;

import com.example.tomcattest.model.User;
import com.example.tomcattest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsernameEager(username);
        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException(username + " not found");
        }

        User user = userOpt.get();

        UserDetails userDetails = new AppUserDetails(user);

        return userDetails;
    }
}