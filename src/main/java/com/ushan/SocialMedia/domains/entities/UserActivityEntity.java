package com.ushan.SocialMedia.domains.entities;

import com.ushan.SocialMedia.enums.Activity;
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
@Table(name = "user_activities")
public class UserActivityEntity {
    @Id
    @SequenceGenerator(name="user_activities_id_sequence", sequenceName="user_activities_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_activities_id_sequence")
    private Long userActivityId;

    @Enumerated(EnumType.STRING)
    private Activity activityType;
    private LocalDate activityTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
