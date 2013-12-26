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
		
		//Aplicar Soma Ponderada com Gestor de Perfil Ambiental
		ManipuladorProperties manip = new ManipuladorProperties();
		SomaPonderada sp = new SomaPonderada(manip.getArquivoMediaDasConfiancas());

		
    	ArrayList<RankingIndicador> linhaRanking = new ArrayList<RankingIndicador>();
    	ArrayList<RankingIndicador> lr = new ArrayList<RankingIndicador>();

    	linhaRanking = sp.getListaRankingIndicador();
    	lr = sp.minimizarIndicadoresSociais(linhaRanking);
    	
    	ArrayList<TuplaRankingIndicador> resultadoSPPA = new ArrayList<TuplaRankingIndicador>();
    	resultadoSPPA = sp.aplicarSomaPonderada(lr, new BigDecimal(0.14), new BigDecimal(0.14), new BigDecimal(0.14), 
    			new BigDecimal(0.14), new BigDecimal(0.14), new BigDecimal(0.07), new BigDecimal(0.07), 
    			new BigDecimal(0.07), new BigDecimal(0.07), new BigDecimal(0.07));
    	
    	System.out.println("Ranqueamento segundo perfil ambiental");
    	for(int i=0; i < sp.ranquear(resultadoSPPA).size(); i++) {
    		System.out.println(sp.ranquear(resultadoSPPA).get(i));
    	}
    	
		//Aplicar Soma Ponderada com Gestor de Perfil Social
    	SomaPonderada sp1 = new SomaPonderada(manip.getArquivoMediaDasConfiancas());
    	ArrayList<RankingIndicador> linhaRanking2 = new ArrayList<RankingIndicador>();
    	ArrayList<RankingIndicador> lr2 = new ArrayList<RankingIndicador>();
    	
    	linhaRanking2 = sp1.getListaRankingIndicador();
    	
    	lr2 = sp1.minimizarIndicadoresAmbientais(linhaRanking2);
    	
    	ArrayList<TuplaRankingIndicador> resultadoSPPS = new ArrayList<TuplaRankingIndicador>();
    	resultadoSPPS = sp1.aplicarSomaPonderada(lr2, new BigDecimal(0.07), new BigDecimal(0.07), new BigDecimal(0.07), 
    			new BigDecimal(0.07), new BigDecimal(0.07), new BigDecimal(0.14), new BigDecimal(0.14), 
    			new BigDecimal(0.14), new BigDecimal(0.14), new BigDecimal(0.14));

    	System.out.println("Ranqueamento segundo perfil social");
    	for(int i=0; i < sp1.ranquear(resultadoSPPS).size(); i++) {
    		System.out.println(sp1.ranquear(resultadoSPPS).get(i));
    	}

    	//Aplicar Soma Ponderada com Gestor de Perfil Hibrido
    	SomaPonderada sp2 = new SomaPonderada(manip.getArquivoMediaDasConfiancas());
    	ArrayList<RankingIndicador> linhaRanking3 = new ArrayList<RankingIndicador>();
    	
    	linhaRanking3 = sp2.getListaRankingIndicador();
    	
    	ArrayList<TuplaRankingIndicador> resultadoSPPH = new ArrayList<TuplaRankingIndicador>();
    	resultadoSPPH = sp2.aplicarSomaPonderada(linhaRanking3, new BigDecimal(0.02), new BigDecimal(0.02), 
    			new BigDecimal(0.02), new BigDecimal(0.02), new BigDecimal(0.02), new BigDecimal(0.02), 
    			new BigDecimal(0.02), new BigDecimal(0.02), new BigDecimal(0.02), new BigDecimal(0.02));
    	
    	System.out.println("Ranqueamento segundo perfil hibrido");
    	for(int i=0; i < sp2.ranquear(resultadoSPPH).size(); i++) {
    		System.out.println(sp2.ranquear(resultadoSPPH).get(i));
    	}

	}
}
