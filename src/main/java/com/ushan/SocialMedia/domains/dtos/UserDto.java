package com.ushan.SocialMedia.domains.dtos;

import com.ushan.SocialMedia.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private ProfileDto profile;
    private String firstName;
    private String lastName;
    private String bio;
    private String password;
    private String address;
    private LocalDate dateOfBirth;
    private Gender gender;

}
