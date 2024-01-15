package com.ushan.SocialMedia.domains.dtos;

import com.ushan.SocialMedia.domains.entities.PageEntity;
import com.ushan.SocialMedia.domains.entities.PostEntity;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDto {

    private Long reportId;

    private String reportReason;

    private Long reportedUserId;

    private Long postId;

    private Long pageId;

    private LocalDate reportDate;

    private ReportStatus reportStatus;

}
