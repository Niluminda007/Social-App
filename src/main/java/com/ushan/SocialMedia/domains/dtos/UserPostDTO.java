package com.ushan.SocialMedia.domains.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {
    private Long postId;
    private String content;
    private List<ImageDto> images;
    private String location;
    private Set<TagDto> tags;
    private LocalDate creationDate;
    private UserDto user;
    private Set<LikeDto> likes;
    private List<CommentDto> comments;
    private List<ReportDto> reports;


}
