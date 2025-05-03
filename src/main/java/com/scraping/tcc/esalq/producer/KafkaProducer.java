package com.scraping.tcc.esalq.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scraping.tcc.esalq.model.Acao;

@EnableKafka
@Service
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	// Método para enviar mensagem
	public void sendMessage(Acao acao, String topic) {
		try {
			String message = convertClassToString(acao);

			kafkaTemplate.send(new ProducerRecord<>(topic, message));
			logger.info("Mensagem enviada: " + message);
		} catch (Exception e) {
			logger.info("Erro ao enviar mensagem: " + e + ", mensagem: " + acao);
			throw e;
		}
	}

	public static String convertClassToString(Acao acao) {
		try {
			return objectMapper.writeValueAsString(acao);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao desserializar o ativo", e);
		}
	}
}
