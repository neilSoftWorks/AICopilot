package com.example.applicationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class ApplicationSystemApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        SpringApplication.run(com.example.applicationsystem.ApplicationSystemApplication.class);
        Thread.sleep(10000); // Adjust as needed
    }
}
