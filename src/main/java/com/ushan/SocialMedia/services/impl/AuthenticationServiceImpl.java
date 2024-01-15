package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.dtos.UserDto;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.domains.reponses.AuthenticationRequest;
import com.ushan.SocialMedia.domains.reponses.AuthenticationResponse;
import com.ushan.SocialMedia.domains.reponses.RegisterRequest;
import com.ushan.SocialMedia.mappers.Mapper;
import com.ushan.SocialMedia.services.AuthenticationService;
import com.ushan.SocialMedia.services.JwtService;
import com.ushan.SocialMedia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final Mapper<UserEntity, UserDto> userMapper;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        UserEntity user = userService.createUser(userMapper.mapFrom(request.getUser()));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getUsername(),
                       request.getPassword()
               )
       );
       UserEntity user = userService.findByUsername(request.getUsername()).orElseThrow();
       String jwtToken = jwtService.generateToken(user);
       return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
