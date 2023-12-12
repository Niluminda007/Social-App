package com.ushan.SocialMedia.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_settings")
public class UserSettingEntity {
    @Id
    @SequenceGenerator(name="user_settings_id_sequence", sequenceName="user_settings_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_settings_id_sequence")
    private Long userSettingsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "setting_id")
    private SettingEntity setting;

}
