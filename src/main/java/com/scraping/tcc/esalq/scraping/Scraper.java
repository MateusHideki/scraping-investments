package com.scraping.tcc.esalq.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.scraping.tcc.esalq.model.Acao;

@Component
public class Scraper {

	public Acao recuperaValor(String ticker) throws Exception {
		try {
			Acao acao = new Acao();
			// Conecta e faz o download da página
			Document doc = Jsoup.connect("https://statusinvest.com.br/acoes/" + ticker).get();
			acao.setTicker(ticker);
			// Seleciona todos os links da página
			Element valor = doc.select("div[title='Valor atual do ativo'] strong.value").first();
			acao.setValorAtual(valor.text());
			valor = doc.select("div.w-lg-100 b.v-align-middle").first();
			acao.setVariacaoAtivoDiaAnterior(valor.text());
			valor = doc.select("div[title='Valorização no preço do ativo com base no mês atual'] span.sub-value b.v-align-middle").first();
			acao.setVariacaoValorizacaoMesAtual(valor.text());
			valor = doc.select("div[title='Valorização no preço do ativo com base nos últimos 12 meses'] strong.value").first();
			acao.setVariacaoValorizacaoAnoAnterior(valor.text());
			return acao;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
