package com.ushan.SocialMedia.services.impl;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.dtos.UserDto;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.mappers.Mapper;
import com.ushan.SocialMedia.repositories.PostRepository;
import com.ushan.SocialMedia.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final Mapper<PostEntity ,PostDto> postMapper;


    @Override
    public PostEntity createPost(PostDto post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserEntity user = (UserEntity) authentication.getPrincipal();

        PostEntity postEntity = postMapper.mapFrom(post);
        postEntity.setUser(user);
        return postRepository.save(postEntity);
    }
}
