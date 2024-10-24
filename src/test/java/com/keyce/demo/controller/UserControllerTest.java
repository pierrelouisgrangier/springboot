package com.keyce.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.keyce.demo.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

    @MockBean
    private UserService userService;
	@Test
	@WithMockUser(username = "user", roles = {"USER"})
	public void testGetWithUser() throws Exception {
		mockMvc.perform(get("/user")).andExpect(status().isOk());
	}
	
	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/user")).andExpect(status().isUnauthorized());
	}

}
