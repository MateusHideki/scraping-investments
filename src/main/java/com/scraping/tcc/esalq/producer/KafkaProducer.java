package com.scraping.tcc.esalq.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Método para enviar mensagem
    public void sendMessage(String message, String topic) {
        try {
            kafkaTemplate.send(new ProducerRecord<>(topic, message));
            System.out.println("Mensagem enviada: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
