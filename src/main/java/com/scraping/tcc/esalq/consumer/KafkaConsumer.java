package com.scraping.tcc.esalq.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "scraping-topico", groupId = "grupo-teste")
    public void listen(String message) {
        System.out.println("🎯 Mensagem recebida do Kafka: " + message);
    }
}
