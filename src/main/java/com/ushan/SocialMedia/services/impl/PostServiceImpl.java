package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.dtos.ImageDto;
import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.dtos.TagDto;
import com.ushan.SocialMedia.domains.dtos.UserDto;
import com.ushan.SocialMedia.domains.entities.*;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ushan.SocialMedia.mappers.Mapper;
import com.ushan.SocialMedia.repositories.PostRepository;
import com.ushan.SocialMedia.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final Mapper<PostEntity, PostDto> postMapper;
    private final Mapper<UserEntity , UserDto> userMapper;


    @Override
    @Transactional
    public PostEntity createPost(PostDto post) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) authentication.getPrincipal();
        PostEntity postEntity =  postMapper.mapFrom(post);
        postEntity.setUser(user);


        log.info(String.valueOf(postEntity));

        return postRepository.save(postEntity);

    }
}
