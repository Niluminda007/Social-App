package com.ushan.SocialMedia.repositories;

import com.ushan.SocialMedia.domains.entities.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
