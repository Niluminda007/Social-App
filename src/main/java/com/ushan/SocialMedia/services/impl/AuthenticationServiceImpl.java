package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.domains.reponses.AuthenticationRequest;
import com.ushan.SocialMedia.domains.reponses.AuthenticationResponse;
import com.ushan.SocialMedia.domains.reponses.RegisterRequest;
import com.ushan.SocialMedia.enums.UserRole;
import com.ushan.SocialMedia.repositories.UserRepository;
import com.ushan.SocialMedia.services.AuthenticationService;
import com.ushan.SocialMedia.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(UserRole.USER)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getUserName(),
                       request.getPassword()
               )
       );
       UserEntity user = userRepository.findByUsername(request.getUserName()).orElseThrow();
       String jwtToken = jwtService.generateToken(user);
       return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
