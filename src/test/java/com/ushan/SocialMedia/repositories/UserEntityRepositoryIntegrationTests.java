package com.ushan.SocialMedia.repositories;

import com.ushan.SocialMedia.TestDataUtil;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
public class UserEntityRepositoryIntegrationTests {
    private final UserRepository underTest;

    @Autowired
    public UserEntityRepositoryIntegrationTests(UserRepository underTest) {
        this.underTest = underTest;
    }
    @Transactional
    @Test
    public void testThatUserCanBeCreatedAndRecalled() {
        UserEntity userEntity = TestDataUtil.generateUserEntity();
        underTest.save(userEntity);
        Optional<UserEntity> results = underTest.findById(userEntity.getUserId());
        assertThat(results).isPresent();
        UserEntity retrievedUser = results.get();

        assertThat(retrievedUser.getProfile()).isNotNull();
        assertThat(retrievedUser).isEqualTo(userEntity);



    }

}
