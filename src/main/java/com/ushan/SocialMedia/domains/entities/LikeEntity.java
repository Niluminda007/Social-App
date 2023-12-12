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
@Table(name = "likes")
public class LikeEntity {
    @Id
    @SequenceGenerator(name="likes_id_sequence", sequenceName="likes_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "likes_id_sequence")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private PageEntity page;

    @ManyToOne
    @JoinColumn(name  = "user_id")
    private UserEntity user;

    private LocalDate likedDate;


}
