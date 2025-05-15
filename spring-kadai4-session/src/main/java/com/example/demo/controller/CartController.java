package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

@Controller
public class CartController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	Cart cart;

	@GetMapping({ "/cart/login", "/cart/logout" })
	public String index() {
		session.invalidate();
		return "cartLogin";
	}

	@PostMapping("/cart/login")
	public String login(@RequestParam("username") String username) {
		account.setUsername(username);
		return "cart";
	}

	@GetMapping("/cart")
	public String showCart() {
		return "cart";
	}

	@GetMapping("/cart/clear")
	public String clearCart() {
		List<Item> allItems = cart.getItems();
		allItems.clear();
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam(name = "price", defaultValue = "0") int price,
			Model model) {

		Item item = new Item(name, price);
		model.addAttribute("item", item);

		List<Item> allItems = cart.getItems();
		allItems.add(item);
		return "cart";
	}

}
