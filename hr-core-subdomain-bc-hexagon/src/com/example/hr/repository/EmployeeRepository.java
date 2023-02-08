package com.example.hr.repository;

import java.util.Optional;

import com.example.hexgonal.Port;
import com.example.hexgonal.PortType;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Port(type = PortType.DRIVEN_PORT)
public interface EmployeeRepository {

	Optional<Employee> findByTcKimlikNo(TcKimlikNo kimlikNo);

	Employee persist(Employee employee);

	void removeEmployee(Employee employee);

}
