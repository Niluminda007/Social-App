package com.ushan.SocialMedia.domains.entities;

import com.ushan.SocialMedia.enums.NotificationType;
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
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @SequenceGenerator(name="notifications_id_sequence", sequenceName="notifications_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifications_id_sequence")
    private Long notificationId;

    private String content;

    private LocalDate notificationDate;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String sourceEntity;

    private Long sourceEntityId;

    private Boolean readStatus;

    private String actionUrl;

}
