package com.scraping.tcc.esalq.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
    @GetMapping("/scraping/{ticker}")
    public Acao hello(@PathVariable String ticker) throws Exception {
    	System.out.println("teste -> ");
    	Acao acao = scraper.recuperaValor(ticker);
    	System.out.println("teste -> "+  acao.getTicker());
    	producer.sendMessage(acao.getTicker(), "scraping-topico");
        return acao;
    }
    

}
