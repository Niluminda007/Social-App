package com.ushan.SocialMedia.domains.entities;

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
@Table(
        name = "follow_relation",uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_follow_relations",
                columnNames = {"follower_id", "following_id"}
        ),
        @UniqueConstraint(
                name = "unique_inverse_follow_relations",
                columnNames = { "following_id" , "follower_id"}
        )

}
)
public class FollowRelationEntity {
    @Id
    @SequenceGenerator(name="follow_relation_entity_id_sequence", sequenceName="follow_relation_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_relation_entity_id_sequence")
    private Long followRelationId;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private UserEntity following;

    private LocalDate followingDate;
}
