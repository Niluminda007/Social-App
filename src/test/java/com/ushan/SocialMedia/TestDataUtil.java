package com.ushan.SocialMedia;

import com.ushan.SocialMedia.domains.entities.ImageEntity;
import com.ushan.SocialMedia.domains.entities.ProfileEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.enums.Gender;

import java.time.LocalDate;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static UserEntity generateUserEntity() {
        return UserEntity.builder()
                .userId(1L)
                .profile(generateProfileEntity())
                .firstName("Ushan")
                .lastName("Jayawardana")
                .address("No 51 Nagahawatte Road Maharagama")
                .bio("To infinity and beyond")
                .dateOfBirth(LocalDate.now())
                .password("123bub")
                .gender(Gender.MALE)
                .build();
    }

    public static ProfileEntity generateProfileEntity() {
        return ProfileEntity.builder()
                .profileId(1L)
                .userName("ushan123")
                .name("Ushan Niluminda")
                .email("ushan@gmail.com")
                .profilePicture(generateProfileImage())
                .build();
    }
    public static ImageEntity generateProfileImage(){
        return ImageEntity.builder()
                .imageId(1L)
                .lowQImageUrl("https://example.com/lowQImage.jpg")
                .highQImageUrl("https://example.com/highQImage.jpg")
                .build();
    }
    public static ImageEntity generateBackgroundImage() {
        return ImageEntity.builder()
                .imageId(2L)
                .lowQImageUrl("https://example.com/lowQBackgroundImage.jpg")
                .highQImageUrl("https://example.com/highQBackgroundImage.jpg")
                .build();
    }
}
