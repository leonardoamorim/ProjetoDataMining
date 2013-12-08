package br.com.weka.mineracao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.weka.comparator.TuplaComparator;
import br.com.weka.model.Tupla;
import br.com.weka.manipulador.*;


public class Mineracao {
	
	private List<String[]> lista = new ArrayList<String[]>();
	private List<String[]> listaIndicadores = new ArrayList<String[]>();
	private List<Tupla> listaRankingIndicadores = new ArrayList<Tupla>();
	private int totalGeralMarcacoes = 0;

    public Mineracao() throws IOException {  
    	ManipuladorProperties manip = new ManipuladorProperties();
	    File arquivoCSV = new File(manip.getArquivoDatawarehouse());  
	    FileReader fr = new FileReader(arquivoCSV);  
	    BufferedReader br = new BufferedReader(fr);  
	                     
	    String linha;  
	    while ((linha = br.readLine()) != null) {  
	        String registro[] = linha.split(",");  
	        lista.add(registro);  
	    } 
	    
	    if (lista.size() > 0) {  
    		// percorrer todos os indicadores	
		for(int j=1; j <= 59; j++){
			// lista de todos registros
			for (int i = 1; i < lista.size(); i++) {  
		            	String[] indicador = {null,null};
		            	// qual indicador pertence
		            	indicador[0] = ""+j;
		            	// valor do registro
		            	indicador[1] = lista.get(i)[j];
		                this.listaIndicadores.add(indicador);
	            	}
            }  
        } 
    }
    
    public void startMineracao(){
			for(int i=1; i <=59; i++){
				int qtdeRegistros = contarTotalDeRegistrosPorTipoDeIndicador(i);
				int qtdeMarcacoes = contarTotalDeMarcacaoPorTipoDeIndicador(i);
				setTotalGeralMarcacoes(getTotalGeralMarcacoes() + qtdeMarcacoes);

            	// qual indicador pertence
				Tupla tupla = new Tupla(i, qtdeRegistros, qtdeMarcacoes);
            	
				listaRankingIndicadores.add(tupla);
			}
			
    }

    
	public void ordenaPorRanking(){
    	Collections.sort(listaRankingIndicadores, new TuplaComparator());
	}
    
	
	public int contarTotalDeRegistrosPorTipoDeIndicador(int indicador){
		int qtdeRegistros = 0;
		for (int i=0; i < listaIndicadores.size(); i++) {
			if(listaIndicadores.get(i)[0].trim().equalsIgnoreCase(String.valueOf(indicador))){
				listaIndicadores.get(i)[1] = listaIndicadores.get(i)[1].replaceAll(" ", "");
				if(!listaIndicadores.get(i)[1].equalsIgnoreCase("0")){
					qtdeRegistros++;
				}
			}
		}
		return qtdeRegistros;
	}
	
	public int contarTotalDeMarcacaoPorTipoDeIndicador(int indicador){
		int qtdeMarcacao = 0;
		for (int i=0; i < listaIndicadores.size(); i++) {
			if(listaIndicadores.get(i)[0].trim().equalsIgnoreCase(String.valueOf(indicador))){
				listaIndicadores.get(i)[1] = listaIndicadores.get(i)[1].replaceAll(" ", "");
				if(!listaIndicadores.get(i)[1].equalsIgnoreCase("0")){
					qtdeMarcacao = qtdeMarcacao + Integer.parseInt(listaIndicadores.get(i)[1]);
				}
			}
		}
		return qtdeMarcacao;
	}
	
	public void geraArquivoComRankingIndicadores() throws IOException{
		ManipuladorProperties manip = new ManipuladorProperties();
		List list = new ArrayList();
			list = getListaRankingIndicadores();
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
	}
	
	public int somaTotalQtdMarcadores() throws IOException {
		int soma = 0;
		ManipuladorProperties manip = new ManipuladorProperties();
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
	
	public int getQtdMarcadores(String indicador) throws IOException {
		int qtd = 0;
		ManipuladorProperties manip = new ManipuladorProperties();
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
	
	public List<Tupla> getListaRankingIndicadores() {
		return listaRankingIndicadores;
	}

	public void setListaRankingIndicadores(List<Tupla> listaRankingIndicadores) {
		this.listaRankingIndicadores = listaRankingIndicadores;
	}

	public int getTotalGeralMarcacoes() {
		return totalGeralMarcacoes;
	}

	public void setTotalGeralMarcacoes(int totalGeralMarcacoes) {
		this.totalGeralMarcacoes = totalGeralMarcacoes;
	}
	
	

}
