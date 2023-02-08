package com.example.hr.application.business;

import java.util.Objects;
import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.event.EmployeeFiredEvent;
import com.example.hr.application.business.event.EmployeeHiredEvent;
import com.example.hr.application.business.event.HrEvent;
import com.example.hr.application.business.exception.ExistingEmployeeException;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private final EmployeeRepository employeeRepository;
	private final EventPublisher<HrEvent> eventPublisher;
	
	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher<HrEvent> eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		Objects.requireNonNull(employee);
		var kimlikNo = employee.getTcKimlikNo();
		var optionalEmployee = employeeRepository.findByTcKimlikNo(kimlikNo);
		if (optionalEmployee.isPresent())
			throw new ExistingEmployeeException(kimlikNo);
		var persistedEmployee = employeeRepository.persist(employee);
		var event = new EmployeeHiredEvent(kimlikNo);
		eventPublisher.publish(event);
		return persistedEmployee;
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo kimlikNo) {
		Objects.requireNonNull(kimlikNo);
		var employeeFound = employeeRepository.findByTcKimlikNo(kimlikNo);
		employeeFound.ifPresent( firedEmployee -> {
			employeeRepository.removeEmployee(firedEmployee);
			var event = new EmployeeFiredEvent(firedEmployee);
			eventPublisher.publish(event);
		});
		return employeeFound;
	}

	@Override
	public Optional<Employee> findEmployee(TcKimlikNo kimlikNo) {
		Objects.requireNonNull(kimlikNo);		
		return employeeRepository.findByTcKimlikNo(kimlikNo);
	}

}
