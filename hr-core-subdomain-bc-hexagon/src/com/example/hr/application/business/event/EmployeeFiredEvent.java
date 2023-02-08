package com.example.hr.application.business.event;

import com.example.hr.domain.Employee;

public class EmployeeFiredEvent extends HrEvent {

	private final Employee employee;

	public EmployeeFiredEvent(Employee employee) {
		super(employee.getTcKimlikNo());
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
