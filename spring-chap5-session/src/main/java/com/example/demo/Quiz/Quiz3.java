package com.example.demo.Quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("お金を入れてください:");
		int price = scan.nextInt();

		if (price < 120) {
			System.out.println("お金が足りません");
		} else {
			System.out.println("購入できました。おつりは" + (price - 120) + "円です");
		}

		scan.close();
	}
}
