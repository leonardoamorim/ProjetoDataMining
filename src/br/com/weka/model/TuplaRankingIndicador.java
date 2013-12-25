package br.com.weka.model;

import java.math.BigDecimal;

public class TuplaRankingIndicador {
	private String indicador;
	private BigDecimal somaLinha;
	
	public TuplaRankingIndicador(String indicador, BigDecimal somaLinha) {
		super();
		this.indicador = indicador;
		this.somaLinha = somaLinha;
	}
	
	
	
	public TuplaRankingIndicador() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	public BigDecimal getSomaLinha() {
		return somaLinha;
	}
	public void setSomaLinha(BigDecimal somaLinha) {
		this.somaLinha = somaLinha;
	}
	@Override
	public String toString() {
		return indicador + "," + String.valueOf(somaLinha);
	}

}
