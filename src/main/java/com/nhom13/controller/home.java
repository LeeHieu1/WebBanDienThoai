package com.nhom13.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class home {
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
