package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.JobStyle;
import com.example.validation.Iban;
import com.example.validation.TcKimlikNo;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class EmployeeEntity {
	@TcKimlikNo
	@Id
	private String identity;
	@Size(min = 2)
	@Column(name="fname")
	private String firstName;
	@Size(min = 2)
	@Column(name="lname")
	private String lastName;
	@Iban
	private String iban;
	private double salary;
	@Column(name="byear")
	private int birthYear;
	@Enumerated(EnumType.ORDINAL)
	private FiatCurrency currency;
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Department department;
	@Enumerated(EnumType.STRING)
	private JobStyle jobStyle;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
}
