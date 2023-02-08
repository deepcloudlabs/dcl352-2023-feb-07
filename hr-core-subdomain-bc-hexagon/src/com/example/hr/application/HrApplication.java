package com.example.hr.application;

import java.util.Optional;

import com.example.hexgonal.Port;
import com.example.hexgonal.PortType;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Port(type=PortType.DRIVING_PORT)
public interface HrApplication {
	Employee hireEmployee(Employee employee);
	Optional<Employee> fireEmployee(TcKimlikNo kimlikNo);
	Optional<Employee> findEmployee(TcKimlikNo kimlikNo);
}
