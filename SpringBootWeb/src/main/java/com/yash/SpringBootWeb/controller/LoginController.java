package com.yash.SpringBootWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String welcome(@RequestParam("loginId") String userName, Model model) {

		if (authentication(userName)) {
			model.addAttribute("message", userName);
			return "welcome";
		} else {
			model.addAttribute("errorMsg", "User is Not Authorized");
			return "logout";
		}

	}

	public static boolean authentication(String userName) {

		return userList().contains(userName);
	}

	private static List<String> userList() {
		List<String> userList = new ArrayList<String>();
		userList.add("Asheesh");
		userList.add("Aatish");
		return userList;
	}

}
