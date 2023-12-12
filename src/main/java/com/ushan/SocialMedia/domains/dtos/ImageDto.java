package com.ushan.SocialMedia.domains.dtos;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {
    private Long imageId;
    private String lowQImageUrl;
    private String highQImageUrl;


}
