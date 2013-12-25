package br.com.weka.model;

import java.math.BigDecimal;

public class RankingIndicador {
	
	private String indicador;
	private BigDecimal mediaConfiancaAgua;
	private BigDecimal mediaConfiancaAr;
	private BigDecimal mediaConfiancaSolo;
	private BigDecimal mediaConfiancaDesmatamento;
	private BigDecimal mediaConfiancaInvasaoAmbiental;
	private BigDecimal mediaConfiancaSeguranca;
	private BigDecimal mediaConfiancaEducacao;
	private BigDecimal mediaConfiancaSaude;
	private BigDecimal mediaConfiancaInfraestruturaUrbana;
	private BigDecimal mediaConfiancaInvasaoSocial;
	
	
	
	public RankingIndicador(String indicador, BigDecimal mediaConfiancaAgua,
			BigDecimal mediaConfiancaAr, BigDecimal mediaConfiancaSolo,
			BigDecimal mediaConfiancaDesmatamento,
			BigDecimal mediaConfiancaInvasaoAmbiental,
			BigDecimal mediaConfiancaSeguranca,
			BigDecimal mediaConfiancaEducacao, BigDecimal mediaConfiancaSaude,
			BigDecimal mediaConfiancaInfraestruturaUrbana,
			BigDecimal mediaConfiancaInvasaoSocial) {
		super();
		this.indicador = indicador;
		this.mediaConfiancaAgua = mediaConfiancaAgua;
		this.mediaConfiancaAr = mediaConfiancaAr;
		this.mediaConfiancaSolo = mediaConfiancaSolo;
		this.mediaConfiancaDesmatamento = mediaConfiancaDesmatamento;
		this.mediaConfiancaInvasaoAmbiental = mediaConfiancaInvasaoAmbiental;
		this.mediaConfiancaSeguranca = mediaConfiancaSeguranca;
		this.mediaConfiancaEducacao = mediaConfiancaEducacao;
		this.mediaConfiancaSaude = mediaConfiancaSaude;
		this.mediaConfiancaInfraestruturaUrbana = mediaConfiancaInfraestruturaUrbana;
		this.mediaConfiancaInvasaoSocial = mediaConfiancaInvasaoSocial;
	}
	public RankingIndicador() {
		super();
	}
	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	public BigDecimal getMediaConfiancaAr() {
		return mediaConfiancaAr;
	}
	public void setMediaConfiancaAr(BigDecimal mediaConfiancaAr) {
		this.mediaConfiancaAr = mediaConfiancaAr;
	}
	public BigDecimal getMediaConfiancaAgua() {
		return mediaConfiancaAgua;
	}
	public void setMediaConfiancaAgua(BigDecimal mediaConfiancaAgua) {
		this.mediaConfiancaAgua = mediaConfiancaAgua;
	}
	public BigDecimal getMediaConfiancaSolo() {
		return mediaConfiancaSolo;
	}
	public void setMediaConfiancaSolo(BigDecimal mediaConfiancaSolo) {
		this.mediaConfiancaSolo = mediaConfiancaSolo;
	}
	public BigDecimal getMediaConfiancaDesmatamento() {
		return mediaConfiancaDesmatamento;
	}
	public void setMediaConfiancaDesmatamento(BigDecimal mediaConfiancaDesmatamento) {
		this.mediaConfiancaDesmatamento = mediaConfiancaDesmatamento;
	}
	public BigDecimal getMediaConfiancaInvasaoAmbiental() {
		return mediaConfiancaInvasaoAmbiental;
	}
	public void setMediaConfiancaInvasaoAmbiental(
			BigDecimal mediaConfiancaInvasaoAmbiental) {
		this.mediaConfiancaInvasaoAmbiental = mediaConfiancaInvasaoAmbiental;
	}
	public BigDecimal getMediaConfiancaSeguranca() {
		return mediaConfiancaSeguranca;
	}
	public void setMediaConfiancaSeguranca(BigDecimal mediaConfiancaSeguranca) {
		this.mediaConfiancaSeguranca = mediaConfiancaSeguranca;
	}
	public BigDecimal getMediaConfiancaEducacao() {
		return mediaConfiancaEducacao;
	}
	public void setMediaConfiancaEducacao(BigDecimal mediaConfiancaEducacao) {
		this.mediaConfiancaEducacao = mediaConfiancaEducacao;
	}
	public BigDecimal getMediaConfiancaSaude() {
		return mediaConfiancaSaude;
	}
	public void setMediaConfiancaSaude(BigDecimal mediaConfiancaSaude) {
		this.mediaConfiancaSaude = mediaConfiancaSaude;
	}
	public BigDecimal getMediaConfiancaInfraestruturaUrbana() {
		return mediaConfiancaInfraestruturaUrbana;
	}
	public void setMediaConfiancaInfraestruturaUrbana(
			BigDecimal mediaConfiancaInfraestruturaUrbana) {
		this.mediaConfiancaInfraestruturaUrbana = mediaConfiancaInfraestruturaUrbana;
	}
	public BigDecimal getMediaConfiancaInvasaoSocial() {
		return mediaConfiancaInvasaoSocial;
	}
	public void setMediaConfiancaInvasaoSocial(
			BigDecimal mediaConfiancaInvasaoSocial) {
		this.mediaConfiancaInvasaoSocial = mediaConfiancaInvasaoSocial;
	}
	@Override
	public String toString() {
		return  indicador + ","
				+ mediaConfiancaAgua + ","
				+ mediaConfiancaAr + ","
				+ mediaConfiancaSolo + ","
				+ mediaConfiancaDesmatamento + ","
				+ mediaConfiancaInvasaoAmbiental + ","
				+ mediaConfiancaSeguranca + ","
				+ mediaConfiancaEducacao + ","
				+ mediaConfiancaSaude + ","
				+ mediaConfiancaInfraestruturaUrbana + ","
				+ mediaConfiancaInvasaoSocial;
	}
	
	

}
