package br.com.weka.decisao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.weka.comparator.TuplaRankingIndicadorComparator;
import br.com.weka.manipulador.ManipuladorProperties;
import br.com.weka.model.RankingIndicador;
import br.com.weka.model.TuplaRankingIndicador;

public class SomaPonderada {
	
	private List<String[]> lista = new ArrayList<String[]>();

		
	public SomaPonderada(String caminhoDoArquivo) throws IOException {  
	    File arquivoCSV = new File(caminhoDoArquivo);  
	    FileReader fr = new FileReader(arquivoCSV);  
	    BufferedReader br = new BufferedReader(fr);  
	                     
	    String linha;  
	    while ((linha = br.readLine()) != null) {  
	        String registro[] = linha.split(",");  
	        lista.add(registro);  
	    } 
    }

	 public ArrayList<RankingIndicador> getListaRankingIndicador(){
	    	ArrayList<RankingIndicador> linhaRanking = new ArrayList<RankingIndicador>();
	    	if (lista.size() > 0) {  
	            for (int i = 1; i < lista.size(); i++) {  
	            	RankingIndicador ri = new RankingIndicador();
	            	ri.setIndicador(lista.get(i)[0]);
	            	ri.setMediaConfiancaAgua(new BigDecimal(lista.get(i)[1]));
	            	ri.setMediaConfiancaAr(new BigDecimal(lista.get(i)[2]));
	            	ri.setMediaConfiancaSolo(new BigDecimal(lista.get(i)[3]));
	            	ri.setMediaConfiancaDesmatamento(new BigDecimal(lista.get(i)[4]));
	            	ri.setMediaConfiancaInvasaoAmbiental(new BigDecimal(lista.get(i)[5]));
	            	ri.setMediaConfiancaSeguranca(new BigDecimal(lista.get(i)[6]));
	            	ri.setMediaConfiancaEducacao(new BigDecimal(lista.get(i)[7]));
	            	ri.setMediaConfiancaSaude(new BigDecimal(lista.get(i)[8]));
	            	ri.setMediaConfiancaInfraestruturaUrbana(new BigDecimal(lista.get(i)[9]));
	            	ri.setMediaConfiancaInvasaoSocial(new BigDecimal(lista.get(i)[10]));
	            	linhaRanking.add(ri);
	            }  
	        }  
	    	return linhaRanking;
	    }
	
	 	public BigDecimal somarLinha(RankingIndicador ri) {
	 		BigDecimal soma = new BigDecimal(0);
	 		soma = ri.getMediaConfiancaAgua().add(ri.getMediaConfiancaAr()).
	 				add(ri.getMediaConfiancaDesmatamento()).add(ri.getMediaConfiancaSolo()).
	 				add(ri.getMediaConfiancaInvasaoAmbiental()).add(ri.getMediaConfiancaSeguranca()).
	 				add(ri.getMediaConfiancaEducacao()).add(ri.getMediaConfiancaSaude()).
	 				add(ri.getMediaConfiancaInfraestruturaUrbana()).add(ri.getMediaConfiancaInvasaoSocial())
	 				;
	 		return soma;
	 	}
	 	
	 	public RankingIndicador normalizarLinha(RankingIndicador ri) {
	 		RankingIndicador normalizado = new RankingIndicador();
	 		BigDecimal[] n = new BigDecimal[10];
	 				n[0] = ri.getMediaConfiancaAgua().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[1] = ri.getMediaConfiancaAr().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[2] = ri.getMediaConfiancaSolo().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[3] = ri.getMediaConfiancaDesmatamento().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[4] = ri.getMediaConfiancaInvasaoAmbiental().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[5] = ri.getMediaConfiancaSeguranca().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[6] = ri.getMediaConfiancaEducacao().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[7] = ri.getMediaConfiancaSaude().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[8] = ri.getMediaConfiancaInfraestruturaUrbana().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				n[9] = ri.getMediaConfiancaInvasaoSocial().divide(somarLinha(ri),MathContext.DECIMAL32).round(new MathContext(4));
	 				normalizado.setIndicador(ri.getIndicador());
	 				normalizado.setMediaConfiancaAgua(n[0]);
	 				normalizado.setMediaConfiancaAr(n[1]);
	 				normalizado.setMediaConfiancaSolo(n[2]);
	 				normalizado.setMediaConfiancaDesmatamento(n[3]);
	 				normalizado.setMediaConfiancaInvasaoAmbiental(n[4]);
	 				normalizado.setMediaConfiancaSeguranca(n[5]);
	 				normalizado.setMediaConfiancaEducacao(n[6]);
	 				normalizado.setMediaConfiancaSaude(n[7]);
	 				normalizado.setMediaConfiancaInfraestruturaUrbana(n[8]);
	 				normalizado.setMediaConfiancaInvasaoSocial(n[9]);
	 		return normalizado;
	 	}
	 	
	 	public ArrayList<RankingIndicador> normalizarListaMinimizada(ArrayList<RankingIndicador> lista) {
	    	
	 		ArrayList<RankingIndicador> listaNormalizada = new ArrayList<RankingIndicador>();
	 		RankingIndicador [] novoRanking = new RankingIndicador[10];

	 		for(int i=0;i<lista.size();i++){ 
	    		novoRanking[i] = new RankingIndicador(
	    				lista.get(i).getIndicador(),
	    				lista.get(i).getMediaConfiancaAgua(),
	    				lista.get(i).getMediaConfiancaAr(),
	    				lista.get(i).getMediaConfiancaSolo(),
	    				lista.get(i).getMediaConfiancaDesmatamento(),
	    				lista.get(i).getMediaConfiancaInvasaoAmbiental(),
	    				lista.get(i).getMediaConfiancaSeguranca(),
	    				lista.get(i).getMediaConfiancaEducacao(),
	    				lista.get(i).getMediaConfiancaSaude(),
	    				lista.get(i).getMediaConfiancaInfraestruturaUrbana(),
	    				lista.get(i).getMediaConfiancaInvasaoSocial()
	    				);
	    		} 
	 		
	 		for(int i=0; i< 10; i++) {
	 			listaNormalizada.add(normalizarLinha(novoRanking[i]));
	 		}
	 		
	 		return listaNormalizada;
	 	}
	 	
	 	public BigDecimal descobrirMaior(BigDecimal[] media) {
	 		BigDecimal maior = media[0];
	 		boolean x;
	 		int y;
	 		for(int i=1; i < media.length; i++) {
	 			y = maior.compareTo(media[i]);
	 			if(y == -1) x = true;
	 				else x = false;
	 			
	 		if(x) {
	 			maior = media[i];
	 			}
	 		}
	 		return maior;
	 	}
	 	
	 	
	 	public ArrayList<RankingIndicador> minimizarIndicadoresSociais(ArrayList<RankingIndicador> lista) {
	 		lista = getListaRankingIndicador();
	 		
	 		ArrayList<RankingIndicador> novaLista = new ArrayList<RankingIndicador>();
	 		RankingIndicador[] ri = new RankingIndicador[10];
	 		
	 		BigDecimal maiorSeguranca,maiorEducacao,maiorSaude,
	 					maiorInfraestruturaUrbana,maiorInvasaoSocial;
	 		
	 		
	 		BigDecimal[] seguranca = {lista.get(0).getMediaConfiancaSeguranca(), lista.get(1).getMediaConfiancaSeguranca(),
	 				lista.get(2).getMediaConfiancaSeguranca(), lista.get(3).getMediaConfiancaSeguranca(),
	 				lista.get(4).getMediaConfiancaSeguranca(), lista.get(5).getMediaConfiancaSeguranca(),
	 				lista.get(6).getMediaConfiancaSeguranca(), lista.get(7).getMediaConfiancaSeguranca(),
	 				lista.get(8).getMediaConfiancaSeguranca(), lista.get(9).getMediaConfiancaSeguranca()
	 		};
	 		
	 		
	 		BigDecimal[] educacao = {lista.get(0).getMediaConfiancaEducacao(), lista.get(1).getMediaConfiancaEducacao(),
	 				lista.get(2).getMediaConfiancaEducacao(), lista.get(3).getMediaConfiancaEducacao(),
	 				lista.get(4).getMediaConfiancaEducacao(), lista.get(5).getMediaConfiancaEducacao(),
	 				lista.get(6).getMediaConfiancaEducacao(), lista.get(7).getMediaConfiancaEducacao(),
	 				lista.get(8).getMediaConfiancaEducacao(), lista.get(9).getMediaConfiancaEducacao()
	 		};
	 		
	 		BigDecimal[] saude = {lista.get(0).getMediaConfiancaSaude(), lista.get(1).getMediaConfiancaSaude(),
	 				lista.get(2).getMediaConfiancaSaude(), lista.get(3).getMediaConfiancaSaude(),
	 				lista.get(4).getMediaConfiancaSaude(), lista.get(5).getMediaConfiancaSaude(),
	 				lista.get(6).getMediaConfiancaSaude(), lista.get(7).getMediaConfiancaSaude(),
	 				lista.get(8).getMediaConfiancaSaude(), lista.get(9).getMediaConfiancaSaude()
	 		};
	 		
	 		BigDecimal[] infraestruturaUrbana = {lista.get(0).getMediaConfiancaInfraestruturaUrbana(), lista.get(1).getMediaConfiancaInfraestruturaUrbana(),
	 				lista.get(2).getMediaConfiancaInfraestruturaUrbana(), lista.get(3).getMediaConfiancaInfraestruturaUrbana(),
	 				lista.get(4).getMediaConfiancaInfraestruturaUrbana(), lista.get(5).getMediaConfiancaInfraestruturaUrbana(),
	 				lista.get(6).getMediaConfiancaInfraestruturaUrbana(), lista.get(7).getMediaConfiancaInfraestruturaUrbana(),
	 				lista.get(8).getMediaConfiancaInfraestruturaUrbana(), lista.get(9).getMediaConfiancaInfraestruturaUrbana()
	 		};
	 		
	 		BigDecimal[] invasaoSocial = {lista.get(0).getMediaConfiancaInvasaoSocial(), lista.get(1).getMediaConfiancaInvasaoSocial(),
	 				lista.get(2).getMediaConfiancaInvasaoSocial(), lista.get(3).getMediaConfiancaInvasaoSocial(),
	 				lista.get(4).getMediaConfiancaInvasaoSocial(), lista.get(5).getMediaConfiancaInvasaoSocial(),
	 				lista.get(6).getMediaConfiancaInvasaoSocial(), lista.get(7).getMediaConfiancaInvasaoSocial(),
	 				lista.get(8).getMediaConfiancaInvasaoSocial(), lista.get(9).getMediaConfiancaInvasaoSocial()
	 		};
	 		
	 		maiorSeguranca = descobrirMaior(seguranca).round(new MathContext(4));
	 		maiorEducacao = descobrirMaior(educacao).round(new MathContext(4));
	 		maiorSaude = descobrirMaior(saude).round(new MathContext(4));
	 		maiorInfraestruturaUrbana = descobrirMaior(infraestruturaUrbana).round(new MathContext(4));
	 		maiorInvasaoSocial = descobrirMaior(invasaoSocial).round(new MathContext(4));
	 		
            for (int i = 0; i < 10; i++) { 
            	ri[i] = new RankingIndicador(
            	lista.get(i).getIndicador(),
            	lista.get(i).getMediaConfiancaAgua(),
            	lista.get(i).getMediaConfiancaAr(),
            	lista.get(i).getMediaConfiancaSolo(),
            	lista.get(i).getMediaConfiancaDesmatamento(),
            	lista.get(i).getMediaConfiancaInvasaoAmbiental(),
            	maiorSeguranca.subtract(lista.get(i).getMediaConfiancaSeguranca()),
            	maiorEducacao.subtract(lista.get(i).getMediaConfiancaEducacao()),
            	maiorSaude.subtract(lista.get(i).getMediaConfiancaSaude()),
            	maiorInfraestruturaUrbana.subtract(lista.get(i).getMediaConfiancaInfraestruturaUrbana()),
            	maiorInvasaoSocial.subtract(lista.get(i).getMediaConfiancaInvasaoSocial())
            	);
            	novaLista.add(ri[i]);
            }  	 		
	 		return novaLista;
	 	}
	 	
	 	public ArrayList<RankingIndicador> minimizarIndicadoresAmbientais(ArrayList<RankingIndicador> lista) {
	 		lista = getListaRankingIndicador();
	 		
	 		ArrayList<RankingIndicador> novaLista = new ArrayList<RankingIndicador>();
	 		RankingIndicador[] ri = new RankingIndicador[10];
	 		
	 		BigDecimal maiorAgua,maiorAr,maiorSolo,
	 					maiorDesmatamento,maiorInvasaoAmbiental;
	 		
	 		
	 		BigDecimal[] agua = {lista.get(0).getMediaConfiancaAgua(), lista.get(1).getMediaConfiancaAgua(),
	 				lista.get(2).getMediaConfiancaAgua(), lista.get(3).getMediaConfiancaAgua(),
	 				lista.get(4).getMediaConfiancaAgua(), lista.get(5).getMediaConfiancaAgua(),
	 				lista.get(6).getMediaConfiancaAgua(), lista.get(7).getMediaConfiancaAgua(),
	 				lista.get(8).getMediaConfiancaAgua(), lista.get(9).getMediaConfiancaAgua()
	 		};
	 		
	 		
	 		BigDecimal[] ar = {lista.get(0).getMediaConfiancaAr(), lista.get(1).getMediaConfiancaAr(),
	 				lista.get(2).getMediaConfiancaAr(), lista.get(3).getMediaConfiancaAr(),
	 				lista.get(4).getMediaConfiancaAr(), lista.get(5).getMediaConfiancaAr(),
	 				lista.get(6).getMediaConfiancaAr(), lista.get(7).getMediaConfiancaAr(),
	 				lista.get(8).getMediaConfiancaAr(), lista.get(9).getMediaConfiancaAr()
	 		};
	 		
	 		BigDecimal[] solo = {lista.get(0).getMediaConfiancaSolo(), lista.get(1).getMediaConfiancaSolo(),
	 				lista.get(2).getMediaConfiancaSolo(), lista.get(3).getMediaConfiancaSolo(),
	 				lista.get(4).getMediaConfiancaSolo(), lista.get(5).getMediaConfiancaSolo(),
	 				lista.get(6).getMediaConfiancaSolo(), lista.get(7).getMediaConfiancaSolo(),
	 				lista.get(8).getMediaConfiancaSolo(), lista.get(9).getMediaConfiancaSolo()
	 		};
	 		
	 		BigDecimal[] desmatamento = {lista.get(0).getMediaConfiancaDesmatamento(), lista.get(1).getMediaConfiancaDesmatamento(),
	 				lista.get(2).getMediaConfiancaDesmatamento(), lista.get(3).getMediaConfiancaDesmatamento(),
	 				lista.get(4).getMediaConfiancaDesmatamento(), lista.get(5).getMediaConfiancaDesmatamento(),
	 				lista.get(6).getMediaConfiancaDesmatamento(), lista.get(7).getMediaConfiancaDesmatamento(),
	 				lista.get(8).getMediaConfiancaDesmatamento(), lista.get(9).getMediaConfiancaDesmatamento()
	 		};
	 		
	 		BigDecimal[] invasaoAmbiental = {lista.get(0).getMediaConfiancaInvasaoAmbiental(), lista.get(1).getMediaConfiancaInvasaoAmbiental(),
	 				lista.get(2).getMediaConfiancaInvasaoAmbiental(), lista.get(3).getMediaConfiancaInvasaoAmbiental(),
	 				lista.get(4).getMediaConfiancaInvasaoAmbiental(), lista.get(5).getMediaConfiancaInvasaoAmbiental(),
	 				lista.get(6).getMediaConfiancaInvasaoAmbiental(), lista.get(7).getMediaConfiancaInvasaoAmbiental(),
	 				lista.get(8).getMediaConfiancaInvasaoAmbiental(), lista.get(9).getMediaConfiancaInvasaoAmbiental()
	 		};
	 		
	 		maiorAgua = descobrirMaior(agua).round(new MathContext(4));
	 		maiorAr = descobrirMaior(ar).round(new MathContext(4));
	 		maiorSolo = descobrirMaior(solo).round(new MathContext(4));
	 		maiorDesmatamento = descobrirMaior(desmatamento).round(new MathContext(4));
	 		maiorInvasaoAmbiental = descobrirMaior(invasaoAmbiental).round(new MathContext(4));
	 		
            for (int i = 0; i < 10; i++) { 
            	ri[i] = new RankingIndicador(
            	lista.get(i).getIndicador(),
             	maiorAgua.subtract(lista.get(i).getMediaConfiancaAgua()),
            	maiorAr.subtract(lista.get(i).getMediaConfiancaAr()),
            	maiorSolo.subtract(lista.get(i).getMediaConfiancaSolo()),
            	maiorDesmatamento.subtract(lista.get(i).getMediaConfiancaDesmatamento()),
            	maiorInvasaoAmbiental.subtract(lista.get(i).getMediaConfiancaInvasaoAmbiental()),
            	lista.get(i).getMediaConfiancaSeguranca(),
            	lista.get(i).getMediaConfiancaEducacao(),
            	lista.get(i).getMediaConfiancaSaude(),
            	lista.get(i).getMediaConfiancaInfraestruturaUrbana(),
            	lista.get(i).getMediaConfiancaInvasaoSocial()
            	);
            	novaLista.add(ri[i]);
            }  	 		
	 		return novaLista;
	 	}
	 	
	 	public ArrayList<TuplaRankingIndicador> aplicarSomaPonderada(ArrayList<RankingIndicador> lista,
	 			BigDecimal pesoAgua, BigDecimal pesoAr, BigDecimal pesoSolo, BigDecimal pesoDesmatamento,
	 			BigDecimal pesoInvasaoAmbiental,BigDecimal pesoSeguranca, BigDecimal pesoEducacao, BigDecimal pesoSaude, 
	 			BigDecimal pesoInfraestruturaUrbana, BigDecimal pesoInvasaoSocial
	 			) {
	 		
	 		ArrayList<RankingIndicador> listaNormalizada = new ArrayList<RankingIndicador>();
	 		RankingIndicador [] rankingNormalizado = new RankingIndicador[10];
	 		ArrayList<TuplaRankingIndicador> tri =  new ArrayList<TuplaRankingIndicador>();
	 		
	 		BigDecimal resultado = new BigDecimal(0);
	 		
	 		
	    	listaNormalizada = normalizarListaMinimizada(lista);
	    	
	    	//Instanciando cada objeto RankingIndicador
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
	    		resultado = rankingNormalizado[i].getMediaConfiancaAgua().multiply(pesoAgua).add(rankingNormalizado[i].getMediaConfiancaAr().multiply(pesoAr)).
	    		add(rankingNormalizado[i].getMediaConfiancaSolo().multiply(pesoSolo).
	    				add(rankingNormalizado[i].getMediaConfiancaDesmatamento().multiply(pesoDesmatamento)).
	    				add(rankingNormalizado[i].getMediaConfiancaInvasaoAmbiental().multiply(pesoInvasaoAmbiental)).
	    				add(rankingNormalizado[i].getMediaConfiancaSeguranca().multiply(pesoSeguranca)).
	    				add(rankingNormalizado[i].getMediaConfiancaEducacao().multiply(pesoEducacao)).
	    				add(rankingNormalizado[i].getMediaConfiancaSaude().multiply(pesoSaude)).
	    				add(rankingNormalizado[i].getMediaConfiancaInfraestruturaUrbana().multiply(pesoInfraestruturaUrbana)).
	    				add(rankingNormalizado[i].getMediaConfiancaInvasaoSocial().multiply(pesoInvasaoSocial)));
	    		

	    		tri.add(new TuplaRankingIndicador(rankingNormalizado[i].getIndicador(),
	    				resultado.setScale(4,RoundingMode.HALF_UP)));

	    	}
	 		return tri;
	 	}
	 	
	 	public ArrayList<TuplaRankingIndicador> ranquear(ArrayList<TuplaRankingIndicador> resultado) {
	 		
	 	   	Collections.sort(resultado, new TuplaRankingIndicadorComparator());
	    	
	 		return resultado;
	 	}

}
