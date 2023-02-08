package com.example.exercise;

import com.example.hr.domain.Employee;

@SuppressWarnings("unused")
public class Exercise05 {

	public static void main(String[] args) {
		var jack = new Employee.Builder("11111111110")
				               .fullName("jack", "shephard")
				               .salary(100_000)
				               .iban("tr1")
				               .department("IT")
				               .jobStyle("FULL_TIME");

	}

}
