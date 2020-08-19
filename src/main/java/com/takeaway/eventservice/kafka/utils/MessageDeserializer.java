package com.takeaway.eventservice.kafka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.eventservice.kafka.EmployeeEvent;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDeserializer implements Deserializer<EmployeeEvent> {
    @Override
    public EmployeeEvent deserialize(String topic, byte[] data) {

        EmployeeEvent message = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(data, EmployeeEvent.class);
        } catch (IOException e) {
        }
        return message;
    }
}
