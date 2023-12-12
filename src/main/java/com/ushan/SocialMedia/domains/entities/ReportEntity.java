package com.ushan.SocialMedia.domains.entities;

import com.ushan.SocialMedia.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reports")
public class ReportEntity {
    @Id
    @SequenceGenerator(name="reports_id_sequence", sequenceName="reports_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reports_id_sequence")
    private Long reportId;

    private String reportReason;

    @ManyToOne
    @JoinColumn( name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private PageEntity page;

    private LocalDate reportDate;
    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;
}
