package com.example.applicationsystem.consumers;

import com.example.events.BusinessDetailsCreated;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class BusinessDetailsConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Replace with your Kafka brokers
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "your-group-id");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.events"); // Add the package of your events

        KafkaConsumer<String, BusinessDetailsCreated> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("business-details-created"));

        try {
            while (true) {
                ConsumerRecords<String, BusinessDetailsCreated> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, BusinessDetailsCreated> record : records) {
                    System.out.printf("Received event: offset = %d, key = %s, value = %s%n",
                            record.offset(), record.key(), record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
