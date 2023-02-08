package com.example.hr.application.business.event;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.hr.domain.TcKimlikNo;

public abstract class HrEvent {
	private final TcKimlikNo kimlikNo;
	private final String eventId = UUID.randomUUID().toString();
	private final LocalDateTime eventTime = LocalDateTime.now();

	public HrEvent(TcKimlikNo kimlikNo) {
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

	public String getEventId() {
		return eventId;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

}
