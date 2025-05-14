package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;

@Controller
public class ItemController {
	//初期画面を表示（返す）
	@GetMapping("/item")
	public String item() {
		return "item";
	}

	@PostMapping("/item")
	public String itemConfirm(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price, Model model) {
		//												↑空文字にするならIntegerにしないといけない

		//登録する商品をインスタンス化
		Item item = new Item(); //new = Item(name, price)でも良い
		item.setName(name);
		item.setPrice(price);

		//【メイン処理：永続化】データベースへの登録

		//【処理】共用のデータ置き場にリクエストパラメータを置きなおす
		model.addAttribute("item", item);

		//【処理】共用のデータ置き場にリクエストパラメータを置きなおす（アクセッサメソッドなし）
		//model.addAttribute("name", name);
		//model.addAttribute("price", price);

		//画面遷移
		return "item";
	}

}
