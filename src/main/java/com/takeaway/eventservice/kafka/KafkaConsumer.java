package com.takeaway.eventservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.eventservice.model.EmployeeEvent;
import com.takeaway.eventservice.repository.EmployeeRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    private EmployeeRepository employeeEventRepository;

    private static final String TOPIC = "changes.employee";

    private ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC)
    public void messageListener(ConsumerRecord<String, com.takeaway.eventservice.kafka.events.EmployeeEvent> consumerRecord, Acknowledgment ack) throws JsonProcessingException {

        com.takeaway.eventservice.kafka.events.EmployeeEvent value = consumerRecord.value();

        employeeEventRepository.save(mapToEntity(value));
        ack.acknowledge();
    }

    private EmployeeEvent mapToEntity(com.takeaway.eventservice.kafka.events.EmployeeEvent event) throws JsonProcessingException {
        EmployeeEvent entity = new EmployeeEvent();
        entity.setSourceId(event.getSourceId());
        entity.setEventType(event.getEventType().toString());
        entity.setPayload(event.getData());
        return entity;
    }

}
