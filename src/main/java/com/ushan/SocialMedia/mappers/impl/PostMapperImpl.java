package com.ushan.SocialMedia.mappers.impl;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class PostMapperImpl implements Mapper<PostEntity, PostDto> {
    private final ModelMapper modelMapper;

    public PostMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public PostDto mapTo(PostEntity postEntity) {
        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostEntity mapFrom(PostDto postDto) {
        return modelMapper.map(postDto, PostEntity.class);
    }
}
