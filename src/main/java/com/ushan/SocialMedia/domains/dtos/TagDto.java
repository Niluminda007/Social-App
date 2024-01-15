package com.ushan.SocialMedia.domains.dtos;

import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {
    private Long tagId;

    private String tagName;

    private String username;

}
