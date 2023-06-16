package com.springboot.learnrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
	
	@GetMapping
	public static String main() {
		return "Hello worldss";
	}
}
