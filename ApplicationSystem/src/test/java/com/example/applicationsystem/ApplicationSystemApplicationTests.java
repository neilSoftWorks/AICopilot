package com.example.applicationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class ApplicationSystemApplicationTests {

    @Container
    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

    @Test
    void contextLoads() throws InterruptedException {
        System.setProperty("spring.kafka.bootstrap-servers", kafka.getBootstrapServers());
        SpringApplication.run(com.example.applicationsystem.ApplicationSystemApplication.class);

        // Keep the container running for a while to let consumers process messages
        Thread.sleep(10000); // 10 seconds, adjust as needed.
    }
}
