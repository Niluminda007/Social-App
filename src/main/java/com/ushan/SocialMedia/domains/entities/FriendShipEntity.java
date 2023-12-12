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
@Table(
        name = "friendships",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_friendships",
                        columnNames = {"user_id", "friend_id"}
                ),
                @UniqueConstraint(
                        name = "unique_inverse_friendships",
                        columnNames = { "friend_id", "user_id"}
                )
        }
)
public class FriendShipEntity {
    @Id
    @SequenceGenerator(name="friendships_relation_entity_id_sequence", sequenceName="friendships_relation_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendships_relation_entity_id_sequence")
    private Long friendshipId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friend_id")
    private UserEntity friend;

}
