package com.ushan.SocialMedia.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ushan.SocialMedia.TestDataUtil;
import com.ushan.SocialMedia.domains.entities.UserEntity;
import com.ushan.SocialMedia.services.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Slf4j
public class UserControllerIntegrationTest {
    private final MockMvc mockMvc;
    @Autowired
    private final ObjectMapper objectMapper;
    private final UserService userService;


    @Autowired
    public UserControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper, PasswordEncoder passwordEncoder, UserService userService) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.userService = userService;

    }

    @Test
    public void testThatRegistersAUserSuccessfullyAndReturnsHttp200() throws Exception {
        UserEntity userEntity = TestDataUtil.generateUserEntity();
        userEntity.setUserId(null);

        Map<String, Object> userJsonMap = new HashMap<>();
        userJsonMap.put("user", userEntity);
        String userJson = objectMapper.writeValueAsString(userJsonMap);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.token").isNotEmpty()
        );
    }
    @Test
    @Transactional
    public void testThatAuthenticateUserSuccessfullyAndReturnsHttp200WithJwt() throws Exception{
        UserEntity userEntity = TestDataUtil.generateUserEntity();
        userEntity.setUserId(null);
        userService.createUser(userEntity);

        String loginCredentials = objectMapper.writeValueAsString(TestDataUtil.generateLoginCredentials());

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginCredentials)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.token").isNotEmpty()
        );

        // Inside the testThatRegistersAUserSuccessfullyAndReturnsHttp200 method
        log.info("Registered User: {}", userEntity);
        log.info("Encoded Password: {}", userEntity.getPassword());

        log.info("Login Credentials: {}", loginCredentials);
    }
}
