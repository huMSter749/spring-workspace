package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {

	@SuppressWarnings("deprecation")
	public List generate(int charLength, boolean withNumber) {
		//生成した文字列を格納するリストの準備
		List<String> list = new ArrayList<String>();
		String word = "";
		//10個分の文字列を生成するループ
		for (int i = 0; i < 10; i++) {
			if (withNumber == false) {
				word = RandomStringUtils.randomAlphabetic(charLength);
				list.add(word);
			} else {
				word = RandomStringUtils.randomAlphanumeric(charLength);
				list.add(word);
			}
		}
		return list;
	}

}
