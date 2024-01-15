package com.ushan.SocialMedia.controllers;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.helpers.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @PostMapping("/create-post")
    public Result createPost(PostDto postDto){


    }
}
