package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.enums.UserRole;
import com.ushan.SocialMedia.repositories.UserRepository;
import com.ushan.SocialMedia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserEntity createUser(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        return  userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
