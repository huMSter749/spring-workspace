package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping({ "/", "/items" })
	public String index(Model model) {
		//データベースから全てのカテゴリリストを取得
		List<Category> categoryList = categoryRepository.findAll();

		//データベースから全ての商品リストを取得
		List<Item> list = itemRepository.findAll();

		//取得したカテゴリリストと商品リストをデータ置き場に設定
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);

		//画面遷移
		return "items";//ファイル名でなく、相対パスで呼び出し
	}
}
