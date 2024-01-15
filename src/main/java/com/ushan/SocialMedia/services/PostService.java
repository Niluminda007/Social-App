package com.ushan.SocialMedia.services;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
     PostEntity createPost(PostDto post);
}
