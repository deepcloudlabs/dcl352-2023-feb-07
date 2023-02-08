package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.domain.Employee;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.entity.EmployeeEntity;

@Configuration
public class ModelMapperConfig {
	private static final Converter<HireEmployeeRequest, Employee>
	HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER = context -> {
		var request = context.getSource();
		return new Employee.Builder(request.getIdentity())
				           .fullName(request.getFirstName(), request.getLastName())
				           .salary(request.getSalary(), request.getCurrency())
				           .iban(request.getIban())
				           .birthYear(request.getBirthYear())
				           .department(request.getDepartment().name())
				           .jobStyle(request.getJobStyle().name())
				           .photo(request.getPhoto())
				           .build();
	};
	
	private static final Converter<Employee, EmployeeResponse>
	EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER = context -> {
		var employee = context.getSource();
		var response = new EmployeeResponse();
		response.setIdentity(employee.getTcKimlikNo().getValue());
		response.setFirstName(employee.getFullName().firstName());
		response.setLastName(employee.getFullName().lastName());
		response.setSalary(employee.getSalary().getValue());
		response.setCurrency(employee.getSalary().getCurrency());
		response.setIban(employee.getIban().getValue());
		response.setBirthYear(employee.getBirthYear().value());
		response.setDepartment(employee.getDepartment());
		response.setJobStyle(employee.getJobStyle());
		response.setPhoto(employee.getPhoto().getBase64Values());
		return response;
	};	
	
	private static final Converter<EmployeeEntity, Employee>
	EMPLOYEE_ENTITY_TO_EMPLOYEE_CONVERTER = context -> {
		var employeeEntity = context.getSource();
		return new Employee.Builder(employeeEntity.getIdentity())
				           .fullName(employeeEntity.getFirstName(), employeeEntity.getLastName())
				           .salary(employeeEntity.getSalary(), employeeEntity.getCurrency())
				           .iban(employeeEntity.getIban())
				           .birthYear(employeeEntity.getBirthYear())
				           .department(employeeEntity.getDepartment().name())
				           .jobStyle(employeeEntity.getJobStyle().name())
				           .photo(employeeEntity.getPhoto())
				           .build();
	};
	
	private static final Converter<Employee, EmployeeEntity>
	EMPLOYEE_TO_EMPLOYEE_ENTITY_CONVERTER = context -> {
		var employee = context.getSource();
		var employeeEntity = new EmployeeEntity();
		employeeEntity.setIdentity(employee.getTcKimlikNo().getValue());
		employeeEntity.setFirstName(employee.getFullName().firstName());
		employeeEntity.setLastName(employee.getFullName().lastName());
		employeeEntity.setSalary(employee.getSalary().getValue());
		employeeEntity.setCurrency(employee.getSalary().getCurrency());
		employeeEntity.setIban(employee.getIban().getValue());
		employeeEntity.setBirthYear(employee.getBirthYear().value());
		employeeEntity.setDepartment(employee.getDepartment());
		employeeEntity.setJobStyle(employee.getJobStyle());
		employeeEntity.setPhoto(employee.getPhoto().getValues());
		return employeeEntity;
	};	
	
	@Bean
	ModelMapper createModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER, 
				HireEmployeeRequest.class, Employee.class);
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER, 
				Employee.class, EmployeeResponse.class);
		modelMapper.addConverter(EMPLOYEE_ENTITY_TO_EMPLOYEE_CONVERTER, 
				EmployeeEntity.class, Employee.class);
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_ENTITY_CONVERTER, 
				Employee.class, EmployeeEntity.class);
		return modelMapper;
	}
}
