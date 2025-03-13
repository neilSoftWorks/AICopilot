package com.example.applicationsystem;

import com.example.applicationsystem.consumers.BusinessDetailsConsumer;
import com.example.shared.SharedEventDetails;
import org.springframework.beans.factory.annotation.Autowired; // Add this import
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer; // Add this import
import org.apache.kafka.clients.consumer.ConsumerConfig; // Add this import
import org.apache.kafka.common.serialization.StringDeserializer; // Add this import
import java.util.HashMap; // Add this import
import java.util.Map; // Add this import

@Configuration
@Profile("kafka")
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, SharedEventDetails> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.3:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "application-system-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.shared"); // Crucial!
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(SharedEventDetails.class));
    }

    @Bean
    public BusinessDetailsConsumer businessDetailsConsumer(ConsumerFactory<String, SharedEventDetails> consumerFactory) { // Removed @Qualifier
        return new BusinessDetailsConsumer(consumerFactory);
    }
}