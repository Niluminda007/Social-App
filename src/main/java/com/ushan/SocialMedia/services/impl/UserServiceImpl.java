package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.repositories.UserRepository;
import com.ushan.SocialMedia.services.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);

    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
