package br.com.weka.cluster.teste;



import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import br.com.weka.cluster.ClusterizacaoEspacial;
import br.com.weka.cluster.ClusterizacaoTemporal;
import br.com.weka.cluster.ClusterizacaoTemporalPorCluster;
import br.com.weka.manipulador.ManipuladorProperties;
import br.com.weka.mineracao.Confianca;
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
	  
//        clusterizacaoEspacial();
//        clusterizacaoPorClusterEmVariosArquivos();
//        clusterizacaoTemporal();
//        geraDataWareHouse();
//    	  geraRankingIndicadores();
//        geraCalculoSuporteComTodosIndicadores();
//        geraCalculoConfiancaComTodosIndicadores();
        
	  
	  Confianca c = new Confianca();
	  BigDecimal [] mediaConfianca = new BigDecimal[10];
	  String [] lista = geraRanking10Mais();
	  ManipuladorProperties manip = new ManipuladorProperties();
	  BufferedWriter StrW = new BufferedWriter(new FileWriter(manip.getArquivoMediaDasConfiancas()));
	  
	  StrW.write("Indicador" + "," 
			  + "Agua" + ","
			  + "Ar" + ","
			  + "Solo" + ","
			  + "Desmatamento" + ","
			  + "Invasao Ambiental" + ","
			  + "Seguranca" + ","
			  + "Educacao" + ","
			  + "Saude" + ","
			  + "Infraestrutura Urbana" + ","
			  + "Invasao Social" 
			  + "\n");
	  
	  for(int i=0;i<10;i++){
		  
		  ArrayList<Integer> listaGrupoAgua = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoAr = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoSolo = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoDesmatamento = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoInvasaoAmbiental = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoSeguranca = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoEducacao = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoSaude = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoInfraestruturaUrbana = new ArrayList<Integer>();
		  ArrayList<Integer> listaGrupoInvasaoSocial = new ArrayList<Integer>();  
		  
	  // Populando Lista Grupo Agua  
	  for(int x=1;x<=6;x++) { listaGrupoAgua.add(x); }
	  // Populando Lista Grupo Ar
	  for(int x=7;x<=11;x++) { listaGrupoAr.add(x); }
	  // Populando Lista Grupo Solo
	  for(int x=12;x<=17;x++) { listaGrupoSolo.add(x); }
	  // Populando Lista Grupo Desmatamento
	  for(int x=18;x<=21;x++) { listaGrupoDesmatamento.add(x); }
	  // Populando Lista Grupo Invasao Ambiental
	  for(int x=22;x<=23;x++) { listaGrupoInvasaoAmbiental.add(x); }
	  // Populando Lista Grupo Seguranca
	  for(int x=24;x<=31;x++) { listaGrupoSeguranca.add(x); }
	  // Populando Lista Grupo Educacao
	  for(int x=32;x<=37;x++) { listaGrupoEducacao.add(x); }
	  // Populando Lista Grupo Saude
	  for(int x=38;x<=45;x++) { listaGrupoSaude.add(x); }
	  // Populando Lista Grupo Infraestrutura Urbana
	  for(int x=46;x<=57;x++) { listaGrupoInfraestruturaUrbana.add(x); }
	  // Populando Lista Grupo Invasao Social
	  for(int x=58;x<=59;x++) { listaGrupoInvasaoSocial.add(x); }
	  
	  	  if(listaGrupoAgua.contains(Integer.parseInt(lista[i]))) {
	  		listaGrupoAgua.remove(new Integer(Integer.parseInt(lista[i])));
	  		mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
	  	  }
		  
		  if(listaGrupoAr.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoAr.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoSolo.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoSolo.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoDesmatamento.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoDesmatamento.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoInvasaoAmbiental.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoInvasaoAmbiental.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							 ;
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoSeguranca.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoSeguranca.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoEducacao.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoEducacao.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoSaude.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoSaude.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoInfraestruturaUrbana.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoInfraestruturaUrbana.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
		  }
		  
		  if(listaGrupoInvasaoSocial.contains(Integer.parseInt(lista[i]))) {
			  listaGrupoInvasaoSocial.remove(new Integer(Integer.parseInt(lista[i])));
			  mediaConfianca[0] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAgua.get(5)))).
							  divide(new BigDecimal(listaGrupoAgua.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[1] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoAr.get(4)))).
							  divide(new BigDecimal(listaGrupoAr.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[2] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSolo.get(5)))).
							  divide(new BigDecimal(listaGrupoSolo.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[3] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoDesmatamento.get(3)))).
							  divide(new BigDecimal(listaGrupoDesmatamento.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[4] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoAmbiental.get(1))).
							  divide(new BigDecimal(listaGrupoInvasaoAmbiental.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[5] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSeguranca.get(7)))).
							  divide(new BigDecimal(listaGrupoSeguranca.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[6] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoEducacao.get(5)))).
							  divide(new BigDecimal(listaGrupoEducacao.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[7] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoSaude.get(7)))).
							  divide(new BigDecimal(listaGrupoSaude.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[8] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(0))).
					  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(1))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(2)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(3)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(4)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(5)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(6)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(7)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(8)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(9)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(10)))).
							  add(c.calcularConfianca(lista[i], Integer.toString(listaGrupoInfraestruturaUrbana.get(11)))).
							  divide(new BigDecimal(listaGrupoInfraestruturaUrbana.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  );
			  
			  mediaConfianca[9] = c.calcularConfianca(lista[i], Integer.toString(listaGrupoInvasaoSocial.get(0))).
							  divide(new BigDecimal(listaGrupoInvasaoSocial.size()),MathContext.DECIMAL32).round(new MathContext(4))
							  ;
		  }
		
		StrW.write(lista[i] + "," + String.valueOf(mediaConfianca[0])+","+String.valueOf(mediaConfianca[1])+","+String.valueOf(mediaConfianca[2])+","
				 +String.valueOf(mediaConfianca[3])+","+String.valueOf(mediaConfianca[4])+","+String.valueOf(mediaConfianca[5])+","+
				 String.valueOf(mediaConfianca[6])+","+String.valueOf(mediaConfianca[7])+","+String.valueOf(mediaConfianca[8])+","+
				 String.valueOf(mediaConfianca[9]) + "\n");
/*		
		System.out.println(lista[i] + "," + mediaConfianca[0]+","+mediaConfianca[1]+","+mediaConfianca[2]+","
					 +mediaConfianca[3]+","+mediaConfianca[4]+","+mediaConfianca[5]+","+
					 mediaConfianca[6]+","+mediaConfianca[7]+","+mediaConfianca[8]+","+
					 mediaConfianca[9]);
*/		  
	  }
	  StrW.close();
		System.out.println("Arquivo com media das confiancas gerado com sucesso!");
	  
	  
	  

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
	
	public static String[] geraRanking10Mais() throws IOException{
		Mineracao m = new Mineracao();
		m.startMineracao();
		m.ordenaPorRanking();
		String[] l;
		l = m.geraRankingDezMais();
		return l;
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
	
	public static void geraCalculoSuporteComTodosIndicadores() throws IOException{
		Suporte s = new Suporte();
		s.geraCalculoSuporteComTodosIndicadores();
	}
	
	private static void geraCalculoConfiancaComTodosIndicadores() {
		Confianca c = new Confianca();
			try {
				c.geraCalculoConfiacaComTodosIndicadores();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
