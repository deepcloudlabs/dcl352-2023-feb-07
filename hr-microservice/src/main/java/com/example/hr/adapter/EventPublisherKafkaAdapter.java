package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hexgonal.Adapter;
import com.example.hr.application.business.event.HrEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Adapter(port = EventPublisher.class)
public class EventPublisherKafkaAdapter implements EventPublisher<HrEvent> {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String topic;
	private final ObjectMapper objectMapper;
	
	public EventPublisherKafkaAdapter(
			@Value("${topic}") String topic,
			ObjectMapper objectMapper,
			KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
		this.objectMapper = objectMapper;
	}

	@Override
	public void publish(HrEvent event) {
		try {
			var eventAsJson = objectMapper.writeValueAsString(event);
			kafkaTemplate.send(topic, eventAsJson);
		} catch (JsonProcessingException e) {
			System.err.println("Error while converting event to json: %s".formatted(e.getMessage()));
		}
	}

}
