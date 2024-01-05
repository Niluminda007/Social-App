package com.ushan.SocialMedia;

import com.ushan.SocialMedia.domains.entities.ImageEntity;
import com.ushan.SocialMedia.domains.entities.ProfileEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.domains.reponses.AuthenticationRequest;
import com.ushan.SocialMedia.enums.Gender;
import com.ushan.SocialMedia.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


public class TestDataUtil {



    public static UserEntity generateUserEntity() {
        return UserEntity.builder()
                .profile(generateProfileEntity())
                .firstName("Ushan")
                .lastName("Jayawardana")
                .address("No 51 Nagahawatte Road Maharagama")
                .bio("To infinity and beyond")
                .dateOfBirth(LocalDate.now())
                .username("ushan123")
                .userRole(UserRole.USER)
                .password("12345")
                .gender(Gender.MALE)
                .build();
    }

    public static ProfileEntity generateProfileEntity() {
        return ProfileEntity.builder()
                .name("Ushan Niluminda")
                .email("ushan@gmail.com")
                .profilePicture(generateProfileImage())
                .build();
    }
    public static ImageEntity generateProfileImage(){
        return ImageEntity.builder()
                .lowQImageUrl("https://example.com/lowQImage.jpg")
                .highQImageUrl("https://example.com/highQImage.jpg")
                .build();
    }
    public static ImageEntity generateBackgroundImage() {
        return ImageEntity.builder()
                .lowQImageUrl("https://example.com/lowQBackgroundImage.jpg")
                .highQImageUrl("https://example.com/highQBackgroundImage.jpg")
                .build();
    }
    public static AuthenticationRequest generateLoginCredentials() {
        return AuthenticationRequest.builder()
                .userName("ushan123")
                .password("12345")
                .build();
    }
}
