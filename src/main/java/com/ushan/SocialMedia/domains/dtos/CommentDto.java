package com.ushan.SocialMedia.domains.dtos;

import com.ushan.SocialMedia.domains.entities.CommentEntity;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private Long commentId;
    private String content;
    private LocalDate commentedDate;

    private String username;

    private Long postId;

    private Long parentCommentId;

    private List<CommentDto> replyList;
}
