package com.ushan.SocialMedia.domains.entities;

import com.ushan.SocialMedia.enums.GroupRole;
import com.ushan.SocialMedia.enums.MembershipStatus;
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
@Table(name = "group_members")
public class GroupMemberEntity {
    @Id

    @SequenceGenerator(name="group_members_id_sequence", sequenceName="group_members_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_members_id_sequence")
    private Long groupMemberId;

    private LocalDate joinedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Enumerated(EnumType.STRING)
    private MembershipStatus membershipStatus;

    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;


}
