package com.ushan.SocialMedia.services;

import com.ushan.SocialMedia.domains.entities.UserEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface UserService {
    UserEntity createUser(UserEntity user);
    Optional<UserEntity> findByUsername(String username);
}
