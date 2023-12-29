package com.ushan.SocialMedia.controllers;

import com.ushan.SocialMedia.domains.reponses.AuthenticationRequest;
import com.ushan.SocialMedia.domains.reponses.AuthenticationResponse;
import com.ushan.SocialMedia.domains.reponses.RegisterRequest;
import com.ushan.SocialMedia.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hello THere", HttpStatus.OK);
    }

}
