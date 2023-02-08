package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.domain.Employee;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;

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
	@Bean
	ModelMapper createModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(HIRE_EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER, 
				HireEmployeeRequest.class, Employee.class);
		modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER, 
				Employee.class, EmployeeResponse.class);
		return modelMapper;
	}
}
