package com.example.exercise;

import com.example.hr.domain.JobStyle;

public class Exercise03 {

	public static void main(String[] args) {
		var js1 = JobStyle.valueOf("FULL_TIME");
		System.out.println(js1.name());
		System.out.println(js1.ordinal());
		for (var js : JobStyle.values())
			System.out.println("%s\t%d".formatted(js.name(),js.ordinal()));
			
	}

}
