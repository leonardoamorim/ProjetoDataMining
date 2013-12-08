/*
 * Classe com o objetivo de indicar as localizacoes de arquivos
 * atraves do recurso de propriedades do Java
 * alterando apenas o arquivo dados.properties na pasta properties
 */
package br.com.weka.manipulador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManipuladorProperties {

	private String arquivoPrincipal;
	private String arquivoEspacial;
	private String diretorioDestinoArquivoEspacial;
	private String diretorioClustersEspaciais;
	private String diretorioClustersTemporais;
	private String diretorioDestinoDatawarehouse;
	private String arquivoDatawarehouse;
	private String arquivoRanking;
	private String arquivoCalculoSuporte;

	public ManipuladorProperties() throws IOException {
		Properties p = getProp();
		arquivoPrincipal = p.getProperty("prop.arquivo.principal");
		arquivoEspacial = p.getProperty("prop.arquivo.espacial");
		diretorioDestinoArquivoEspacial = p
				.getProperty("prop.diretorio.destino.espacial");
		diretorioClustersTemporais = p
				.getProperty("prop.diretorio.destino.temporal.clusters");
		diretorioDestinoDatawarehouse = p
				.getProperty("prop.diretorio.destino.datawarehouse");
		arquivoDatawarehouse = p.getProperty("prop.arquivo.datawarehouse");
		diretorioClustersEspaciais = p
				.getProperty("prop.diretorio.destino.espacial.clusters");
		arquivoRanking = p.getProperty("prop.arquivo.rankingindicadores");
		arquivoCalculoSuporte = p
				.getProperty("prop.arquivo.calculoSuporteTodosIndicadores");
	}

	public String getArquivoRanking() {
		return arquivoRanking;
	}

	public String getArquivoPrincipal() {
		return arquivoPrincipal;
	}

	public String getArquivoEspacial() {
		return arquivoEspacial;
	}

	public String getDiretorioDestinoArquivoEspacial() {
		return diretorioDestinoArquivoEspacial;
	}

	public String getDiretorioClustersEspaciais() {
		return diretorioClustersEspaciais;
	}

	public String getDiretorioClustersTemporais() {
		return diretorioClustersTemporais;
	}

	public String getDiretorioDestinoDatawarehouse() {
		return diretorioDestinoDatawarehouse;
	}

	public String getArquivoDatawarehouse() {
		return arquivoDatawarehouse;
	}

	public String getArquivoCalculoSuporte() {
		return arquivoCalculoSuporte;
	}

	public void setArquivoCalculoSuporte(String arquivoCalculoSuporte) {
		this.arquivoCalculoSuporte = arquivoCalculoSuporte;
	}

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./properties/dados.properties");
		props.load(file);
		return props;

	}

}