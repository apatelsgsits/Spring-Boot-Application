package com.yash.SpringBootWeb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WelcomeController {
	
	//@Value("${welcome.message:test}")
	@Value("${welcome.message}")
	private String message = "Hello World";
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "main";
	}

	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("message", this.message);
		return "welcome";
	}
	
	@GetMapping("/listData")
	public String sayHello1() {
		return "listData";
	}
}
