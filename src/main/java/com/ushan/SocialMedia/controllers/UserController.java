package com.ushan.SocialMedia.controllers;

import com.ushan.SocialMedia.domains.dtos.UserDto;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.mappers.Mapper;
import com.ushan.SocialMedia.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final Mapper<UserEntity, UserDto> userMapper;
    public UserController(UserService userService , Mapper<UserEntity, UserDto> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping(path = "/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserEntity userEntity = userMapper.mapFrom(user);
        UserEntity savedUserEntity = userService.createUser(userEntity);
        System.out.println(userEntity);
        return new ResponseEntity<>(userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);

    }
}
