package com.takeaway.eventservice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final String TOPIC = "changes.employee";

    @KafkaListener(topics = TOPIC)
    public void messageListener(ConsumerRecord<String, EmployeeEvent> consumerRecord, Acknowledgment ack) {

        String key = consumerRecord.key();
        EmployeeEvent value = consumerRecord.value();
        int partition = consumerRecord.partition();

        System.out.println("Consumed message : " + value
                + " with key : " + key
                + " from partition : "+ partition);

        ack.acknowledge();
    }

}
