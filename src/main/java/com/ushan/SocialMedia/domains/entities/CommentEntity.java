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
@Table(name = "comments")
public class CommentEntity {
    @Id
    @SequenceGenerator(name="comments_entity_id_sequence", sequenceName="comments_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_entity_id_sequence")
    private Long commentId;

    private String content;
    private LocalDate commentedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;


    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment" ,cascade = CascadeType.ALL , orphanRemoval = true)
    private List<CommentEntity> replyList;
}
