package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {
	@GetMapping("/account")
	public String index(Model model) {
		model.addAttribute("account", new Account());
		return "accountForm";
	}

	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		List<String> keikoku = new ArrayList<String>();

		model.addAttribute("name", name);
		if (name.isEmpty()) {
			keikoku.add("名前は必須です");

		} else if (name.length() > 20) {
			keikoku.add("名前は20文字以内で入力して下さい");

		}
		if (email.isEmpty()) {
			keikoku.add("メールアドレスは必須です");

		}
		if (password.isEmpty()) {
			keikoku.add("パスワードは必須です");
		}

		Account account = new Account(name, email, password);

		if (keikoku.size() > 0) {
			model.addAttribute("account", account);
			model.addAttribute("keikoku", keikoku);
			return "accountForm";
		}

		model.addAttribute("account", account);
		return "accountConfirm";
	}

}
