package com.ushan.SocialMedia.services;

import com.ushan.SocialMedia.domains.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity getUserByUserName(String userName);
}
