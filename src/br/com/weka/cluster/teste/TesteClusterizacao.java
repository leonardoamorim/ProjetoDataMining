package br.com.weka.cluster.teste;



import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import br.com.weka.cluster.ClusterizacaoEspacial;
import br.com.weka.cluster.ClusterizacaoTemporal;
import br.com.weka.cluster.ClusterizacaoTemporalPorCluster;
import br.com.weka.mineracao.Datawarehouse;
import br.com.weka.mineracao.Mineracao;
import br.com.weka.model.Estatistica;
import br.com.weka.manipulador.*;
import br.com.weka.model.Tupla;

import java.util.Scanner;

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
      geraRankingIndicadores();
	  
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
		Manipulador manip = new Manipulador();
		ClusterizacaoEspacial clusterizacaoEspacial = new ClusterizacaoEspacial();
		clusterizacaoEspacial.clusterizar(manip.getArquivoPrincipal(), manip.getArquivoEspacial());
	}
	
	private static void clusterizacaoPorClusterEmVariosArquivos(){
		try {
		Manipulador manip = new Manipulador();
		ClusterizacaoTemporalPorCluster ctpc = new ClusterizacaoTemporalPorCluster(manip.getArquivoEspacial());
		ctpc.iniciarRanking();
		System.out.println("---------------- Criado Arquivos ------------------");
		}catch(IOException ex){
			ex.printStackTrace();
		}
			
	}
  
	public static void geraDataWareHouse() throws IOException{
		Manipulador manip = new Manipulador();
		Datawarehouse datawarehouse = new Datawarehouse();
		datawarehouse.geraDataWareHouse(manip.getDiretorioClustersTemporais(), manip.getArquivoDatawarehouse());
	}
	
	public static void geraRankingIndicadores() throws IOException{
		Manipulador manip = new Manipulador();
		Mineracao mineracao;
		List list = new ArrayList();
		try {
			mineracao = new Mineracao();
			mineracao.startMineracao();
			mineracao.ordenaPorRanking();
			list = mineracao.getListaRankingIndicadores();
			Iterator<Tupla> it = list.iterator();  
			String valor;
			try{

				BufferedWriter StrW = new BufferedWriter(new FileWriter(manip.getArquivoRanking()));		
				StrW.write("Indicador" + "," + "Quantidade de registros" + "," + "Quantidade de marcacoes" + "\n");
				while (it.hasNext()) {
					valor = String.valueOf(it.next());
					StrW.write(valor + "\n");
				}
				StrW.close();
				System.out.println("Arquivo com ranking gerado com sucesso!");
				
			}catch (FileNotFoundException ex)
				{ 
					ex.printStackTrace(); 
				}
					catch (IOException e)
				{
					e.printStackTrace(); 
				}
			
			//System.out.println("Ordenacao: " + mineracao.getListaRankingIndicadores());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
