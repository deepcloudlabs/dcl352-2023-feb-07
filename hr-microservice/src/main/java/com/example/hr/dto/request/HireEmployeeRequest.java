package com.example.hr.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.JobStyle;
import com.example.validation.Iban;
import com.example.validation.TcKimlikNo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HireEmployeeRequest {
	@TcKimlikNo
	private String identity;
	@Size(min = 2)
	private String firstName;
	@Size(min = 2)
	private String lastName;
	@Iban
	private String iban;
	private double salary;
	private int birthYear;
	private FiatCurrency currency;
	@NotNull
	private Department department;
	private JobStyle jobStyle;
	private String photo;
	
}
