package com.scraping.tcc.esalq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scraping.tcc.esalq.model.Acao;
import com.scraping.tcc.esalq.producer.KafkaProducer;
import com.scraping.tcc.esalq.scraping.Scraper;

@RestController
public class Controller {

	@Autowired
	private Scraper scraper;
	
	@Autowired
	private KafkaProducer producer;
	
    @Value("${spring.kafka.topic.producer}")
    private String producerTopic;
	
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/scraping/{ticker}")
    public Acao hello(@PathVariable String ticker) throws Exception {
    	logger.info("Iniciando scraping...");
    	Acao acao = scraper.recuperaValor(ticker);
    	producer.sendMessage(acao, producerTopic);
        return acao;
    }
    

}
