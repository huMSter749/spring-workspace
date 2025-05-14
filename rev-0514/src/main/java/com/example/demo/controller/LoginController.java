package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private static final String USER_ID = "student";
	private static final String USER_PASSWORD = "himitu";

	@GetMapping("/login")
	public String index() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("id") String userid,
			@RequestParam("pass") String pass, Model model) {
		String nextPage = "";
		if (USER_ID.equals(userid) && USER_PASSWORD.equals(pass)) {
			nextPage = "index";
		} else {
			String errorMessage = "";
			if (!USER_ID.equals(userid)) {
				errorMessage = "ID不一致";
			} else if (!USER_PASSWORD.equals(pass)) {
				errorMessage = "パスワード不一致";
			}
			model.addAttribute("message", errorMessage);
			nextPage = "login";
		}
		return nextPage;
	}

}
