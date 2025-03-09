package com.example.applicationsystem;

import com.example.applicationsystem.consumers.BusinessDetailsConsumer;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@Profile("kafka")
public class KafkaConfig {

    @Bean
    @Primary
    public ConsumerFactory<String, SharedEventDetails> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    @Primary
    public BusinessDetailsConsumer businessDetailsConsumer(
            @Qualifier("consumerFactory") ConsumerFactory<String, SharedEventDetails> consumerFactory) {
        return new BusinessDetailsConsumer(consumerFactory);
    }
}