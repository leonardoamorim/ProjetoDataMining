package br.com.weka.cluster.teste;



import java.io.IOException;
import java.math.BigDecimal;

import br.com.weka.cluster.ClusterizacaoEspacial;
import br.com.weka.cluster.ClusterizacaoTemporal;
import br.com.weka.cluster.ClusterizacaoTemporalPorCluster;
import br.com.weka.manipulador.ManipuladorProperties;
import br.com.weka.mineracao.Datawarehouse;
import br.com.weka.mineracao.Mineracao;
import br.com.weka.mineracao.Suporte;

/**
 * Esta classe invoca os metodos para clusterizacao espacial e temporal;
 * E tambem o metodo de geracao de Data WareHouse e geracao de Ranking de Indicadores
 */
public class TesteClusterizacao 
  {

		
  public static void main(String[] args) throws Exception
    {
 
//      clusterizacaoEspacial();
//     clusterizacaoPorClusterEmVariosArquivos();
//	    clusterizacaoTemporal();
//  	geraDataWareHouse();
//      geraRankingIndicadores();
//	  System.out.println(somaTotalQtdMarcadores());
//	  System.out.println(getQtdMarcadores("1"));
//	  BigDecimal calcularSuporte = calcularSuporte("1");
//	  System.out.println(calcularSuporte);
	  
	  BigDecimal calcularSuporte2 = calcularSuporte("1","2");
	  System.out.println(calcularSuporte2);
	  
    }

	private static void clusterizacaoTemporal() {
		ClusterizacaoTemporal ct = new ClusterizacaoTemporal();
		try {
			ct.clusterizar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private static void clusterizacaoEspacial() throws Exception {
		ManipuladorProperties manip = new ManipuladorProperties();
		ClusterizacaoEspacial clusterizacaoEspacial = new ClusterizacaoEspacial();
		clusterizacaoEspacial.clusterizar(manip.getArquivoPrincipal(), manip.getArquivoEspacial());
	}
	
	private static void clusterizacaoPorClusterEmVariosArquivos(){
		try {
		ManipuladorProperties manip = new ManipuladorProperties();
		ClusterizacaoTemporalPorCluster ctpc = new ClusterizacaoTemporalPorCluster(manip.getArquivoEspacial());
		ctpc.iniciarRanking();
		System.out.println("---------------- Criado Arquivos ------------------");
		}catch(IOException ex){
			ex.printStackTrace();
		}
			
	}
  
	public static void geraDataWareHouse() throws IOException{
		ManipuladorProperties manip = new ManipuladorProperties();
		Datawarehouse datawarehouse = new Datawarehouse();
		datawarehouse.geraDataWareHouse(manip.getDiretorioClustersTemporais(), manip.getArquivoDatawarehouse());
	}
	
	public static void geraRankingIndicadores() throws IOException{
		Mineracao m = new Mineracao();
		m.startMineracao();
		m.ordenaPorRanking();
		m.geraArquivoComRankingIndicadores();
	}
	
	public static int somaTotalQtdMarcadores() throws IOException {
		Mineracao m = new Mineracao();
		return m.somaTotalQtdMarcadores();
	}
	
	public static int getQtdMarcadores(String indicador) throws IOException {
		Mineracao m = new Mineracao();
		return m.getQtdMarcadores(indicador);

	}
	
	public static BigDecimal calcularSuporte(String indicador) throws IOException {
		Suporte s = new Suporte();
		return s.calcularSuporte(indicador);

	}
	
	public static BigDecimal calcularSuporte(String indicador1, String indicador2) throws IOException {
		Suporte s = new Suporte();
		return s.calcularSuporte(indicador1, indicador2);

	}
	
}
