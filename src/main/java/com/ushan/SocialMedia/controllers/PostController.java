package com.ushan.SocialMedia.controllers;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.dtos.UserPostDTO;
import com.ushan.SocialMedia.domains.helpers.Result;
import com.ushan.SocialMedia.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor

public class PostController {
    private final PostService postService;

    @PostMapping("/create-post")
    public Result createPost(@RequestBody PostDto post){

        return new Result(true, HttpStatus.CREATED, "Post Created Successfully", "Hello There");

    }
}
