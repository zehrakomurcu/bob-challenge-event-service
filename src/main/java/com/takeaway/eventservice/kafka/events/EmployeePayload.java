package com.takeaway.eventservice.kafka.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayload {
    private String name;
    private Date birthday;
    private String email;
    private String departmentName;
}
