package com.ushan.SocialMedia.domains.reponses;

import com.ushan.SocialMedia.domains.dtos.UserDto;
import com.ushan.SocialMedia.domains.entities.ProfileEntity;
import com.ushan.SocialMedia.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private UserDto user;

}
