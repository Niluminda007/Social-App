package com.ushan.SocialMedia.domains.dtos;


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
    private Set<TagDto> tags;
    private LocalDate creationDate;
    private UserDto user;
    private Set<LikeDto> likes;
    private List<CommentDto> comments;
    private Long pageId;
    private Long groupId;
    private List<ReportDto> reports;


}
