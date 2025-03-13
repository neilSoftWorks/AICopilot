package com.example.applicationsystem;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import java.util.HashMap;
import java.util.Map;
import com.example.shared.SharedEventDetails;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, SharedEventDetails> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.3:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "application-system-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonDeserializer.class);
        props.put(org.springframework.kafka.support.serializer.JsonDeserializer.TRUSTED_PACKAGES, "com.example.shared"); // Crucial!
        return new org.springframework.kafka.core.DefaultKafkaConsumerFactory<>(props); // Corrected constructor
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SharedEventDetails> kafkaListenerContainerFactory(ConsumerFactory<String, SharedEventDetails> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, SharedEventDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}