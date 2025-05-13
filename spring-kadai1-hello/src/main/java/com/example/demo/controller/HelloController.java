package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@PostMapping("/hello")
	public String show(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("hobby") String hobby,
			Model model) {
		model.addAttribute("memo", name);
		model.addAttribute("memo2", age);
		if (age < 18) {
			model.addAttribute("danger", "未成年です");
		} else {
			model.addAttribute("danger", "成人してから" + (age - 18) + "年経ちました");
		}
		model.addAttribute("memo3", hobby);
		return "hello";
	}

	@GetMapping("/hello")
	public String input() {
		return "input";
	}

	@GetMapping("/")
	public String index() {
		return "input"; //表示するHTML（遷移先HTML)のファイルベース名
	}

}
