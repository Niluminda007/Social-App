package com.ushan.SocialMedia.domains.entities;

import com.ushan.SocialMedia.enums.RequestStatus;
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
@Table(name = "friendship_requests")
public class FriendshipRequestEntity {

    @Id
    @SequenceGenerator(name="friendship_requests_entity_id_sequence", sequenceName="friendship_requests_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendship_requests_entity_id_sequence")
    private Long friendshipRequestId;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private UserEntity receiver;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(nullable = false)
    private LocalDate requestedDate;
}
