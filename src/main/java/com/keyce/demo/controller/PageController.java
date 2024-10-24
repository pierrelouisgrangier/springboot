package com.keyce.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keyce.demo.service.UserService;

@Controller
public class PageController {

	@Autowired
	private UserService userService;

	/** Home page. */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Welcome");
		return "home";
	}

	/** Home page. */
	@GetMapping("/keyce")
	public String keyce(Model model) {
		model.addAttribute("message", "Welcome to Keyce");
		model.addAttribute("users", userService.getAllUsers());
		return "keyce";
	}
}
