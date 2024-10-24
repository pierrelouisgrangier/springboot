package com.keyce.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.keyce.demo.dto.UserDto;
import com.keyce.demo.model.UserModel;
import com.keyce.demo.repository.UserRepository;

public class UserServiceTest {

	@Test
	public void testGetUser() {
		UserRepository userRepository = mock(UserRepository.class);
		UserModel userModel = new UserModel();
		userModel.setEmail("toto@test.fr");
		userModel.setName("toto");
		userModel.setId(1l);
		Optional<UserModel> optional =  Optional.of(userModel);
		when(userRepository.findById(1l)).thenReturn(optional);
		UserService userService = new UserService(userRepository);
		UserDto userdto = userService.getUser(1);
		assertNotNull(userdto);
		assertEquals("toto@test.fr", userdto.getEmail());
		assertEquals("toto", userdto.getName());
		assertEquals(1, userdto.getId());

	}
}
