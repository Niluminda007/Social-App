package com.ushan.SocialMedia.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "images")
public class ImageEntity {
    @Id
    @SequenceGenerator(name="images_id_sequence", sequenceName="images_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_id_sequence")
    private Long imageId;
    private String lowQImageUrl;
    private String highQImageUrl;

}
