package com.example.hr.infrastructure;

import com.example.hexgonal.Port;
import com.example.hexgonal.PortType;

@Port(type = PortType.DRIVEN_PORT)
public interface EventPublisher<Event> {
	public void publish(Event event);
}
