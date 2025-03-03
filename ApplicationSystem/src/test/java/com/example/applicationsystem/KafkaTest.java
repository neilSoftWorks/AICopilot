package com.example.applicationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(topics = "business-details-created", partitions = 1)
class KafkaTest {

    @Test
    void contextLoads() {
        // This test method can be empty
    }
}
