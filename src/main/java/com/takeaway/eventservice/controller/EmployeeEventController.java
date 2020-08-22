package com.takeaway.eventservice.controller;

import com.takeaway.eventservice.model.EmployeeEvent;
import com.takeaway.eventservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events/employees")
public class EmployeeEventController {

    @Autowired
    private EmployeeRepository employeeEventRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<EmployeeEvent>>> getEmployee(@PathVariable("id") String id) {
        return ResponseEntity.ok(employeeEventRepository.findAllBySourceIdOrderByCreatedAt(id));
    }

}
