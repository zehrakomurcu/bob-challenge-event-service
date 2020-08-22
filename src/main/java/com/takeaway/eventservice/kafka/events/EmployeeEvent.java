package com.takeaway.eventservice.kafka.events;

import lombok.Data;

@Data
public class EmployeeEvent {
    private EventType eventType;
    private String sourceId;
    private EmployeePayload data;

    public enum EventType {
        EMPLOYEE_CREATED, EMPLOYEE_UPDATED, EMPLOYEE_DELETED;
    }

}
