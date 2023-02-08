package com.example.hr.application.business.event;

import com.example.ddd.DomainEvent;
import com.example.hr.domain.TcKimlikNo;

@DomainEvent
public class EmployeeHiredEvent extends HrEvent {

	public EmployeeHiredEvent(TcKimlikNo kimlikNo) {
		super(kimlikNo);
	}

}
