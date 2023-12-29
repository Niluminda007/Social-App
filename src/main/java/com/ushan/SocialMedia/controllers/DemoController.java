package com.ushan.SocialMedia.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class DemoController {
    @GetMapping("/there")
    public ResponseEntity<String> sayHello(){
        try{
            return new ResponseEntity<>("Hello from secured end point", HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;

    }
}
