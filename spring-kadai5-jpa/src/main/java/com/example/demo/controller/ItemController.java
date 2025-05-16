package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CateRepository cateRepository;

	//	@GetMapping("/items")
	//	public String index(Model model) {
	//		List<Item> itemList = itemRepository.findAll();
	//
	//		model.addAttribute("items", itemList);
	//		return "items";
	//	}

	@GetMapping("/items")
	public String cate(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {

		List<Category> cateList = cateRepository.findAll();
		model.addAttribute("categories", cateList);

		List<Item> itemList = null;
		if (categoryId == null) {
			itemList = itemRepository.findAll();
		} else {
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		model.addAttribute("items", itemList);
		return "items";
	}

}
