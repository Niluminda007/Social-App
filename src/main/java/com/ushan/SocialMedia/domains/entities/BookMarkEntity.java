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
@Table(name = "bookmarks")
public class BookMarkEntity {
    @Id
    @SequenceGenerator(name="bookmarks_entity_id_sequence", sequenceName="bookmarks_entity_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmarks_entity_id_sequence")
    private Long bookmarkId;

    @ManyToOne
    @JoinColumn( name = "user_id" )
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private PageEntity page;
}
