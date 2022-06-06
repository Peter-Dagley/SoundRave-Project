package com.qa.soundrave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// Home Page
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
}
