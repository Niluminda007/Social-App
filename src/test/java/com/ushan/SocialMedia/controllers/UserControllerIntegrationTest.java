package com.ushan.SocialMedia.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ushan.SocialMedia.TestDataUtil;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private UserService userService;

    @Autowired
    public UserControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper, UserService userService) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.userService = userService;
    }

    @Test
    public void testThatCreateUserEndPointSuccessfullyReturnHttp201Created() throws Exception {
        UserEntity userEntity = TestDataUtil.generateUserEntity();
        userEntity.setUserId(null);
        String userJson = objectMapper.writeValueAsString(userEntity);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.profile").isNotEmpty()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.profile.email").value(userEntity.getProfile().getEmail())
        );
    }
}
