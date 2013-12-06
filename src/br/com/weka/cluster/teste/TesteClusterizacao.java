package br.com.weka.cluster.teste;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
//      geraRankingIndicadores();
//	  System.out.println(somaTotalQtdMarcadores());
//	  System.out.println(getQtdMarcadores("7"));
	  
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
				//StrW.write("Indicador" + "," + "Quantidade de registros" + "," + "Quantidade de marcacoes" + "\n");
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
	
	public static int somaTotalQtdMarcadores() throws IOException {
		int soma = 0;
		Manipulador manip = new Manipulador();
		try {
			
			BufferedReader StrR = new BufferedReader(new FileReader(manip.getArquivoRanking()));
			String linha = StrR.readLine();
 			while(linha != null) {
				 //  String indicador = linha.substring(0, linha.indexOf(','));
				 //  String qtdRegistros = linha.substring(linha.indexOf(',') + 1, linha.lastIndexOf(','));
				   String qtdMarcacoes = linha.substring(linha.lastIndexOf(',') + 1, linha.length());
				   soma = soma +  Integer.parseInt(qtdMarcacoes);
				   linha = StrR.readLine();
			}
 			StrR.close();

		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
		return soma;
	}
	
	public static int getQtdMarcadores(String indicador) throws IOException {
		int qtd = 0;
		Manipulador manip = new Manipulador();
		try {
			
			BufferedReader StrR = new BufferedReader(new FileReader(manip.getArquivoRanking()));
			String linha = StrR.readLine();
			String ind, qtdMarcacoes;
			
			ind = linha.substring(0, linha.indexOf(','));
			
			while(linha != null)
			{
				ind = linha.substring(0, linha.indexOf(','));
				if(ind.equals(indicador) == true) {
					qtdMarcacoes = linha.substring(linha.lastIndexOf(',') + 1, linha.length());
					qtd = Integer.parseInt(qtdMarcacoes);
					linha = null;
				}
				else linha = StrR.readLine();
					
			}

			StrR.close();

		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
		return qtd;

	}
	
}
