package com.ushan.SocialMedia.services;

import com.ushan.SocialMedia.domains.reponses.AuthenticationRequest;
import com.ushan.SocialMedia.domains.reponses.AuthenticationResponse;
import com.ushan.SocialMedia.domains.reponses.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {


    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
