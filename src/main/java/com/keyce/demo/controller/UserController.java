package com.keyce.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyce.demo.dto.UserDto;
import com.keyce.demo.exception.CreateUserIdException;
import com.keyce.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping()
	public Collection<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/name/{name}")
	public Collection<UserDto> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") long id) {
		return userService.deleteUser(id);
	}
	
	@PostMapping()
	public UserDto createUser(@RequestBody UserDto userDto) throws CreateUserIdException {
		return userService.createUser(userDto);
	}
	
	@PutMapping()
	public UserDto updateUser(@RequestBody UserDto userDto) {
		return userService.updateUser(userDto);
	}
	
	@GetMapping("populate")
	public void populate() throws CreateUserIdException {
		UserDto userDto = new UserDto();
		userDto.setEmail("toto@test.fr");
		userDto.setName("Toto");
		userService.createUser(userDto);
		userDto = new UserDto();
		userDto.setEmail("titi@test.fr");
		userDto.setName("Titi");
		userService.createUser(userDto);
		userDto = new UserDto();
		userDto.setEmail("tata@test.fr");
		userDto.setName("Tata");
		userService.createUser(userDto);
		userDto = new UserDto();
		userDto.setEmail("tutu@test.fr");
		userDto.setName("Tutu");
		userService.createUser(userDto);
	}

}
