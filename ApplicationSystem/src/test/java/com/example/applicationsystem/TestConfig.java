package com.example.applicationsystem;

import com.example.applicationsystem.consumers.BusinessDetailsConsumer;
import com.example.shared.SharedEventDetails;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.ConsumerFactory;

import static org.mockito.Mockito.mock;

@TestConfiguration
@Profile("mock-kafka")
public class TestConfig {

    @Bean
    @Primary
    public BusinessDetailsConsumer businessDetailsConsumer() {
        ConsumerFactory<String, SharedEventDetails> mockConsumerFactory = mock(ConsumerFactory.class);
        return new BusinessDetailsConsumer(mockConsumerFactory);
    }
}