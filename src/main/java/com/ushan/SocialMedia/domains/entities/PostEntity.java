package com.ushan.SocialMedia.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "posts")
public class PostEntity {
    @Id
    @SequenceGenerator(name="posts_id_sequence", sequenceName="posts_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_id_sequence")
    private Long postId;

    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    private List<ImageEntity> images;

    private String location;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval= true)
    private Set<TagEntity> tags;

    private LocalDate creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<LikeEntity> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<CommentEntity> comments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "page_id")
    private PageEntity page;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<ReportEntity> reports;


}
