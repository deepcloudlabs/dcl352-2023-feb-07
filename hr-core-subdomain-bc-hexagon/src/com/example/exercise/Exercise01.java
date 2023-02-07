package com.example.exercise;

import com.example.hr.domain.TcKimlikNo;
import com.example.hr.domain.TcKimlikNoRecord;

public class Exercise01 {

	public static void main(String[] args) {
		var kimlikNo1 = new TcKimlikNoRecord("11111111110");
		System.out.println(kimlikNo1.value());
		var kimlikNo2 = TcKimlikNo.valueOf("11111111110");
		System.out.println(kimlikNo2.getValue());
		var kimlikNo3 = new TcKimlikNoRecord();
		System.out.println(kimlikNo3.value());
	}

}