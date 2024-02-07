package com.ushan.SocialMedia.mappers.impl;

import com.ushan.SocialMedia.domains.dtos.PostDto;
import com.ushan.SocialMedia.domains.dtos.TagDto;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.domains.entities.TagEntity;
import com.ushan.SocialMedia.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapperImpl implements Mapper<TagEntity , TagDto> {
    private final ModelMapper modelMapper;

    public TagMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public TagDto mapTo(TagEntity tagEntity) {
        return modelMapper.map(tagEntity, TagDto.class);
    }

    @Override
    public TagEntity mapFrom(TagDto tagDto) {
        return modelMapper.map(tagDto, TagEntity.class);
    }
}
