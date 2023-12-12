package com.ushan.SocialMedia.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "settings")
public class SettingEntity {
    @Id
    @SequenceGenerator(name="settings_id_sequence", sequenceName="settings_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settings_id_sequence")
    private Long settingId;

    private String settingName;
    private String settingValue;
    private String dataType;
    private String defaultValue;

    private String description;

    @OneToMany(mappedBy = "setting" )
    private List<UserSettingEntity> userSettings;

}
