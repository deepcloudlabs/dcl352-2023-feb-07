package com.example.hr.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.FireEmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;

@Service
public class HrService {
	private final HrApplication hrApplication;

	public HrService(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}

	@Transactional
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public FireEmployeeResponse fireEmployee(String identity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
