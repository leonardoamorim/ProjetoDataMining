package br.com.weka.cluster.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;  

import br.com.weka.model.RankingIndicador;
import br.com.weka.model.TuplaRankingIndicador;
import br.com.weka.comparator.TuplaRankingIndicadorComparator;
import br.com.weka.decisao.SomaPonderada;
import br.com.weka.manipulador.ManipuladorProperties;

public class TesteSomaPonderada {
	



	public static void main(String []args) throws IOException {
		
		ManipuladorProperties manip = new ManipuladorProperties();
		SomaPonderada sp = new SomaPonderada(manip.getArquivoMediaDasConfiancas());

		
    	ArrayList<RankingIndicador> linhaRanking = new ArrayList<RankingIndicador>();
    	ArrayList<RankingIndicador> lr = new ArrayList<RankingIndicador>();
    	ArrayList<RankingIndicador> listaNormalizada = new ArrayList<RankingIndicador>();

    	RankingIndicador [] ranking = new RankingIndicador[10];
    	RankingIndicador [] novoRanking = new RankingIndicador[10];
    	RankingIndicador [] rankingNormalizado = new RankingIndicador[10];

    

    	
    	linhaRanking = sp.getListaRankingIndicador();
    	lr = sp.minimizarIndicadoresSociais(linhaRanking);
    	
    	for(int i=0;i<lr.size();i++){ 
    		novoRanking[i] = new RankingIndicador(
    				lr.get(i).getIndicador(),
    				lr.get(i).getMediaConfiancaAgua(),
    				lr.get(i).getMediaConfiancaAr(),
    				lr.get(i).getMediaConfiancaSolo(),
    				lr.get(i).getMediaConfiancaDesmatamento(),
    				lr.get(i).getMediaConfiancaInvasaoAmbiental(),
    				lr.get(i).getMediaConfiancaSeguranca(),
    				lr.get(i).getMediaConfiancaEducacao(),
    				lr.get(i).getMediaConfiancaSaude(),
    				lr.get(i).getMediaConfiancaInfraestruturaUrbana(),
    				lr.get(i).getMediaConfiancaInvasaoSocial()
    				);
    		} 
    	
    	// Perfil Gestor Ambiental
    	ArrayList<TuplaRankingIndicador> resultadoSPPA = new ArrayList<TuplaRankingIndicador>();
    	resultadoSPPA = sp.aplicarSomaPonderada(lr, new BigDecimal(0.14), new BigDecimal(0.14), new BigDecimal(0.14), 
    			new BigDecimal(0.14), new BigDecimal(0.14), new BigDecimal(0.07), new BigDecimal(0.07), 
    			new BigDecimal(0.07), new BigDecimal(0.07), new BigDecimal(0.07));
    	
    	for(int i=0; i < resultadoSPPA.size(); i++){
    		System.out.println(resultadoSPPA.get(i));
    	}
    	
    	System.out.println("Ranqueamento segundo perfil ambiental");
    	for(int i=0; i < sp.ranquear(resultadoSPPA).size(); i++) {
    		System.out.println(sp.ranquear(resultadoSPPA).get(i));
    	}
    	
    	/*
    	for(int i=0; i < lr.size();i++) {
    		System.out.println(novoRanking[i]);
    	}
    	
    	listaNormalizada = sp.normalizarListaMinimizada(lr);
    	for(int i=0; i < listaNormalizada.size(); i++) {
    		rankingNormalizado[i] = new RankingIndicador(
    				listaNormalizada.get(i).getIndicador(),
    				listaNormalizada.get(i).getMediaConfiancaAgua(),
    				listaNormalizada.get(i).getMediaConfiancaAr(),
    				listaNormalizada.get(i).getMediaConfiancaSolo(),
    				listaNormalizada.get(i).getMediaConfiancaDesmatamento(),
    				listaNormalizada.get(i).getMediaConfiancaInvasaoAmbiental(),
    				listaNormalizada.get(i).getMediaConfiancaSeguranca(),
    				listaNormalizada.get(i).getMediaConfiancaEducacao(),
    				listaNormalizada.get(i).getMediaConfiancaSaude(),
    				listaNormalizada.get(i).getMediaConfiancaInfraestruturaUrbana(),
    				listaNormalizada.get(i).getMediaConfiancaInvasaoSocial()
    				);
    	}
    	
    	for(int i=0; i < 10; i++) {
    		System.out.println(rankingNormalizado[i].toString());
    	}
    	
    	/*
    	for(int i=0;i<linhaRanking.size();i++){ 
    		ranking[i] = new RankingIndicador(
    				linhaRanking.get(i).getIndicador(),
    				linhaRanking.get(i).getMediaConfiancaAgua(),
    				linhaRanking.get(i).getMediaConfiancaAr(),
    				linhaRanking.get(i).getMediaConfiancaSolo(),
    				linhaRanking.get(i).getMediaConfiancaDesmatamento(),
    				linhaRanking.get(i).getMediaConfiancaInvasaoAmbiental(),
    				linhaRanking.get(i).getMediaConfiancaSeguranca(),
    				linhaRanking.get(i).getMediaConfiancaEducacao(),
    				linhaRanking.get(i).getMediaConfiancaSaude(),
    				linhaRanking.get(i).getMediaConfiancaInfraestruturaUrbana(),
    				linhaRanking.get(i).getMediaConfiancaInvasaoSocial()
    				);
    		} 

 //   	for(int i=0; i < linhaRanking.size();i++) {
//    		System.out.println(ranking[i]);
  //  	}
    	
    	lr = sp.minimizarIndicadoresSociais(linhaRanking);
    	
    	for(int i=0;i<lr.size();i++){ 
    		novoRanking[i] = new RankingIndicador(
    				lr.get(i).getIndicador(),
    				lr.get(i).getMediaConfiancaAgua(),
    				lr.get(i).getMediaConfiancaAr(),
    				lr.get(i).getMediaConfiancaSolo(),
    				lr.get(i).getMediaConfiancaDesmatamento(),
    				lr.get(i).getMediaConfiancaInvasaoAmbiental(),
    				lr.get(i).getMediaConfiancaSeguranca(),
    				lr.get(i).getMediaConfiancaEducacao(),
    				lr.get(i).getMediaConfiancaSaude(),
    				lr.get(i).getMediaConfiancaInfraestruturaUrbana(),
    				lr.get(i).getMediaConfiancaInvasaoSocial()
    				);
    		} 

    	for(int i=0; i < lr.size();i++) {
    		System.out.println(novoRanking[i]);
    	}
    	
    	*/
    	
    
    	/*
    	//Instanciar 10 objetos do tipo RankingIndicador
    	for(int i=0;i<linhaRanking.size();i++){ 
    		ranking[i] = new RankingIndicador(
    				linhaRanking.get(i).getIndicador(),
    				linhaRanking.get(i).getMediaConfiancaAgua(),
    				linhaRanking.get(i).getMediaConfiancaAr(),
    				linhaRanking.get(i).getMediaConfiancaSolo(),
    				linhaRanking.get(i).getMediaConfiancaDesmatamento(),
    				linhaRanking.get(i).getMediaConfiancaInvasaoAmbiental(),
    				linhaRanking.get(i).getMediaConfiancaSeguranca(),
    				linhaRanking.get(i).getMediaConfiancaEducacao(),
    				linhaRanking.get(i).getMediaConfiancaSaude(),
    				linhaRanking.get(i).getMediaConfiancaInfraestruturaUrbana(),
    				linhaRanking.get(i).getMediaConfiancaInvasaoSocial()
    				);
    		} 

    	for(int i=0; i < linhaRanking.size();i++) {
    		System.out.println(ranking[i]);
    	}
    	
    
    	
    	
    	Collections.sort(lista, new TuplaRankingIndicadorComparator());
    	System.out.println("Gestor Social");
    	for(int i=0; i < lista.size(); i++) {
    		System.out.println(lista.get(i));
    	}
    	*/

  
    	
    	
    	
    	
	}
}
