package com.example.demo.model;

public class Item {
	private String name;
	private int price;

	public Item() {
	} //デフォルトコンストラクタ

	public Item(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	/*
	 * アクセッサメソッド
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
