package com.ushan.SocialMedia.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "groups")
public class GroupEntity {
    @Id
    @SequenceGenerator(name="groups_entity_id_sequence", sequenceName="groups_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_entity_id_sequence")
    private Long groupId;

    private String groupName;
    private String groupProfilePicture;
    private String groupBackgroundPicture;

    @OneToOne
    @JoinColumn( name = "admin_user_id")
    private UserEntity admin;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<GroupMemberEntity> members;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PostEntity> groupPosts;

    private String description;

    private LocalDate groupCreationDate;
}
