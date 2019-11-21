package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@PostMapping
	public String greetWorld() {
		return "Hello World";
	}
	
	@GetMapping 
	public int world(){
		return 1;
	}

}
