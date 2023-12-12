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
@Table(name = "pages")
public class PageEntity {
    @Id
    @SequenceGenerator(name="pages_id_sequence", sequenceName="pages_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_id_sequence")
    private Long pageId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "admin_user_id")
    private UserEntity admin;

    private String about;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    private List<BookMarkEntity> bookmarks;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    private List<ReportEntity> reports;
}
