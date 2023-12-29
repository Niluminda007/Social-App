package com.ushan.SocialMedia.domains.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {

    private Long profileId;
    private String name;
    private String email;
    private ImageDto profilePicture;
    private ImageDto backgroundPicture;
}
