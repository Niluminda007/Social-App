package com.ushan.SocialMedia.mappers.impl;

import com.ushan.SocialMedia.domains.dtos.ImageDto;
import com.ushan.SocialMedia.domains.dtos.TagDto;
import com.ushan.SocialMedia.domains.entities.ImageEntity;
import com.ushan.SocialMedia.domains.entities.TagEntity;
import com.ushan.SocialMedia.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageMapperImpl implements Mapper<ImageEntity , ImageDto> {
    private final ModelMapper modelMapper;
    public ImageMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ImageDto mapTo(ImageEntity imageEntity) {
        return modelMapper.map(imageEntity, ImageDto.class);
    }

    @Override
    public ImageEntity mapFrom(ImageDto imageDto) {
        return modelMapper.map(imageDto, ImageEntity.class);
    }
}
