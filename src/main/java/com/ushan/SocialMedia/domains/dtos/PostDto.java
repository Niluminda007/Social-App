package com.ushan.SocialMedia.domains.dtos;

import com.ushan.SocialMedia.domains.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long postId;

    private String content;


    private List<ImageDto> images;

    private String location;

    private LocalDate creationDate;
}
