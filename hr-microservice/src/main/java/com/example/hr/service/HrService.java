package com.example.hr.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;

@Service
public class HrService {
	private final HrApplication hrApplication;
	private final ModelMapper modelMapper;
	
	public HrService(HrApplication hrApplication, ModelMapper modelMapper) {
		this.hrApplication = hrApplication;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		var employee = modelMapper.map(request, Employee.class);
		hrApplication.hireEmployee(employee);
		return new HireEmployeeResponse("success");
	}

	@Transactional
	public EmployeeResponse fireEmployee(String identity) {
		return modelMapper.map(
				hrApplication.fireEmployee(TcKimlikNo.valueOf(identity))
				             .orElseThrow(() -> new IllegalArgumentException("cannnot find employee to fire")),
			    EmployeeResponse.class);
	}

	public EmployeeResponse getEmployee(String identity) {
		return modelMapper.map(hrApplication.findEmployee(TcKimlikNo.valueOf(identity))
				.orElseThrow(() -> new IllegalArgumentException("Cannot find employee")),
				EmployeeResponse.class);
	}
	
}
