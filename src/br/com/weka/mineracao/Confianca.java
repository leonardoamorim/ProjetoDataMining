package br.com.weka.mineracao;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

import br.com.weka.manipulador.ManipuladorProperties;
import br.com.weka.model.Indicadores;

public class Confianca {


	public  BigDecimal calcularConfianca(String indicador1, String indicador2) throws IOException {
		Suporte suporte = new Suporte();
		BigDecimal suporte1 = suporte.calcularSuporte(indicador1);
		BigDecimal suporte1AndSuporte2 = suporte.calcularSuporte(indicador1, indicador2);
		BigDecimal somaConfinca = null;
		if(suporte1.equals(new BigDecimal("0")) || suporte1AndSuporte2.equals(new BigDecimal("0"))){
			somaConfinca = new BigDecimal("0");
		}else{
			somaConfinca = suporte1AndSuporte2.divide(suporte1, MathContext.DECIMAL32);
			somaConfinca = somaConfinca.round(new MathContext(3));
		}
		return somaConfinca;

	}
	
	public void geraCalculoConfiacaComTodosIndicadores() throws IOException{
		ManipuladorProperties manip = new ManipuladorProperties();
			try{
				int aux = 0;
				BufferedWriter StrW = new BufferedWriter(new FileWriter(manip.getArquivoCalculoConfianca()));
				String valor = "";
				for (int indicador1 = 1; indicador1 <= 59; indicador1++) {
					aux++;
					for (int indicador2 = 1; indicador2 <= 59; indicador2++) {
						if(indicador2 == 1){
							indicador2 += aux;
						}
						if(indicador2 <= 59){
							BigDecimal valorCalculoConfianca = null;
							valorCalculoConfianca = calcularConfianca(""+indicador1,""+indicador2);
							valor = indicador1+", "+indicador2+", "+String.valueOf(valorCalculoConfianca);
							StrW.write(valor + "\n");
						}
					}
				}
				StrW.close();
				System.out.println("Arquivo com todas as confiancas gerada com sucesso!");
				
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
	
	
}
