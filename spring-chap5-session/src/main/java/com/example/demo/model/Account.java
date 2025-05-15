package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component //こいつがある前提でセッションスコープを記述
@SessionScope //セッション情報を保持
public class Account {
	private String name;//フィールド

	public Account() {//デフォルトコンストラクタ
	}

	//アクセッサメソッド
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
