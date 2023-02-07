package com.example.hr.domain;

import com.example.ddd.Aggregate;
import com.example.ddd.Entity;

// Ubiquitous Language -> Bounded-Context -> [Core] Sub-domain
//  TcKimlikNo, FullName, Iban, Money,...
// Entity Class
//  i. identity
// ii. mutable
@Entity(identity="tcKimlikNo")
@Aggregate
public class Employee {
	private TcKimlikNo tcKimlikNo;
	private FullName fullName;
	private Iban iban;
	private Money salary;
	private BirthYear birthYear;
	private Photo photo;
	private Department department;
	private JobStyle jobStyle;
	
	
}
