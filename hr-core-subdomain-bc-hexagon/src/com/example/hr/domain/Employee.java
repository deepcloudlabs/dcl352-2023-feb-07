package com.example.hr.domain;

import com.example.ddd.Aggregate;
import com.example.ddd.Entity;

// Ubiquitous Language -> Bounded-Context -> [Core] Sub-domain
//  TcKimlikNo, FullName, Iban, Money,...
// Entity Class
//  i. identity
// ii. mutable
@Entity(identity = "tcKimlikNo")
@Aggregate
public class Employee {

	private TcKimlikNo tcKimlikNo;
	private FullName fullName;
	private Iban iban;
	private Money salary;
	private final BirthYear birthYear;
	private Photo photo;
	private Department department;
	private JobStyle jobStyle;

	public Employee(Builder builder) {
		this.tcKimlikNo = builder.tcKimlikNo;
		this.fullName = builder.fullName;
		this.iban = builder.iban;
		this.salary = builder.salary;
		this.birthYear = builder.birthYear;
		this.photo = builder.photo;
		this.department = builder.department;
		this.jobStyle = builder.jobStyle;
	}
	
	public TcKimlikNo getTcKimlikNo() {
		return tcKimlikNo;
	}

	public FullName getFullName() {
		return fullName;
	}

	public Iban getIban() {
		return iban;
	}

	public Money getSalary() {
		return salary;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public Photo getPhoto() {
		return photo;
	}

	public Department getDepartment() {
		return department;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void applySalaryIncrement(double rate) {
		this.salary = this.salary.multiply(1.0+rate/100.0);
	}
	
	public static class Builder {
		private TcKimlikNo tcKimlikNo;
		private FullName fullName;
		private Iban iban;
		private Money salary;
		private BirthYear birthYear;
		private Photo photo;
		private Department department;
		private JobStyle jobStyle;

		public Builder(String value) {
			this.tcKimlikNo = TcKimlikNo.valueOf(value);
		}

		public Builder fullName(String firstName, String lastName) {
			this.fullName = new FullName(firstName, lastName);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}

		public Builder salary(double value) {
			return salary(value, FiatCurrency.TL);
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.makeOf(value, currency);
			return this;
		}
		
		public Builder birthYear(int value) {
			this.birthYear = new BirthYear(value);
			return this;
		}

		public Builder department(String value) {
			this.department = Department.valueOf(value);
			return this;
		}
		
		public Builder photo(byte[] values) {
			this.photo = Photo.of(values);
			return this;
		}
		
		public Builder photo(String values) {
			this.photo = Photo.of(values);
			return this;
		}
		
		public Builder jobStyle(String value) {
			this.jobStyle = JobStyle.valueOf(value);
			return this;
		}
		
		public Employee build() {
			// Policy
			
			// Business Rule
			// Constraint
			// Validation Rules
			// Invariants
			return new Employee(this);
		}
		
	}

}
