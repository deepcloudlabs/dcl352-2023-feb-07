package com.example.exercise;

@SuppressWarnings("unused")
public class Exercise02 {
    // -XX:AutoBoxCacheMax
	public static void main(String[] args) {
		int w = 42; // 4-Byte
		Integer z = 42; // 12-Byte + 4-Byte = 16-Byte
		Integer x = Integer.valueOf(42);
		Integer y = 42;
		Integer u = 549;
		Integer v = 549;
		System.out.println("x==y? "+(x==y));
		System.out.println("u==v? "+(u==v));
	}

}
