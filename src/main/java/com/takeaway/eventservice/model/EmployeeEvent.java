package com.takeaway.eventservice.model;

import com.takeaway.eventservice.kafka.events.EmployeePayload;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "employee_events")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class EmployeeEvent {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "event_Type")
    private String eventType;

    @Column(name= "source_id")
    private String sourceId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private EmployeePayload payload;

    @PrePersist
    private void prePersist(){
        this.createdAt = Instant.now();
    }
}
