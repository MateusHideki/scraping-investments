package com.scraping.tcc.esalq.model;

public class Acao {

	private String ticker;
	private String valorAtual;
	private String variacaoAtivoDiaAnterior;
	private String variacaoValorizacaoMesAtual;
	private String variacaoValorizacaoAnoAnterior;

	public Acao() {
	}

	public Acao(String ticker, String valorAtual, String variacaoAtivoDiaAnterior, String variacaoValorizacaoMesAtual,
			String variacaoValorizacaoAnoAnterior) {
		super();
		this.ticker = ticker;
		this.valorAtual = valorAtual;
		this.variacaoAtivoDiaAnterior = variacaoAtivoDiaAnterior;
		this.variacaoValorizacaoMesAtual = variacaoValorizacaoMesAtual;
		this.variacaoValorizacaoAnoAnterior = variacaoValorizacaoAnoAnterior;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}

	public String getVariacaoAtivoDiaAnterior() {
		return variacaoAtivoDiaAnterior;
	}

	public void setVariacaoAtivoDiaAnterior(String variacaoAtivoDiaAnterior) {
		this.variacaoAtivoDiaAnterior = variacaoAtivoDiaAnterior;
	}

	public String getVariacaoValorizacaoMesAtual() {
		return variacaoValorizacaoMesAtual;
	}

	public void setVariacaoValorizacaoMesAtual(String variacaoValorizacaoMesAtual) {
		this.variacaoValorizacaoMesAtual = variacaoValorizacaoMesAtual;
	}

	public String getVariacaoValorizacaoAnoAnterior() {
		return variacaoValorizacaoAnoAnterior;
	}

	public void setVariacaoValorizacaoAnoAnterior(String variacaoValorizacaoAnoAnterior) {
		this.variacaoValorizacaoAnoAnterior = variacaoValorizacaoAnoAnterior;
	}

	@Override
	public String toString() {
		return "Acao [ticker=" + ticker + ", valorAtual=" + valorAtual + ", variacaoAtivoDiaAnterior="
				+ variacaoAtivoDiaAnterior + ", variacaoValorizacaoMesAtual=" + variacaoValorizacaoMesAtual
				+ ", variacaoValorizacaoAnoAnterior=" + variacaoValorizacaoAnoAnterior + "]";
	}

}
