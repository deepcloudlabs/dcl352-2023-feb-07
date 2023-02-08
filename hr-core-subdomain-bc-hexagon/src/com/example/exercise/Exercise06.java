package com.example.exercise;

import java.math.BigInteger;

public class Exercise06 {

	public static void main(String[] args) {
		String name= "jack";
		name = name.toUpperCase();
		System.out.println(name);
		var number = BigInteger.valueOf(1_000_000);
		number = number.add(BigInteger.ONE);
		System.out.println(number);
	}

}
