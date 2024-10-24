package com.keyce.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.keyce.demo.dto.UserDto;
import com.keyce.demo.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	@WithMockUser(username = "user", roles = { "USER" })
	public void testGetWithUser() throws Exception {
		List<UserDto> userDtos = new ArrayList<>();
		UserDto userDto = new UserDto();
		userDto.setEmail("toto@test.fr");
		userDto.setName("Toto");
		userDto.setId(1l);
		userDtos.add(userDto);
		when(userService.getAllUsers()).thenReturn(userDtos);
		mockMvc.perform(get("/user")).andExpect(status().isOk());
		mockMvc.perform(get("/user")).andExpect(content().contentType(MediaType.APPLICATION_JSON));
		mockMvc.perform(get("/user")).andExpect(content().json("[{\"id\":1,\"email\":\"toto@test.fr\",\"name\":\"Toto\"}]"));
		
	}

	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/user")).andExpect(status().isUnauthorized());
	}

}
