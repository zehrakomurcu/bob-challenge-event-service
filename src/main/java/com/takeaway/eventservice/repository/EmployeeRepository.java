package com.takeaway.eventservice.repository;

import com.takeaway.eventservice.model.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEvent, String> {
    Optional<List<EmployeeEvent>> findAllBySourceIdOrderByCreatedAt(String id);
}
