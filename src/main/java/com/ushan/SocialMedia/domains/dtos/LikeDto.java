package com.ushan.SocialMedia.domains.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeDto {

    private Long likeId;


    private Long postId;

    private Long pageId;


    private String username;

    private LocalDate likedDate;

}
