package br.com.weka.mineracao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.weka.manipulador.ManipuladorProperties;
import br.com.weka.model.Tupla;

public class Suporte {

	public BigDecimal calcularSuporte(String indicador) throws IOException {
		Mineracao m = new Mineracao();
		BigDecimal qtdMarcadores = new BigDecimal(m.getQtdMarcadores(indicador));
		BigDecimal totalQtdMarcadores = new BigDecimal(m.somaTotalQtdMarcadores());
		BigDecimal retorno = qtdMarcadores.divide(totalQtdMarcadores, MathContext.DECIMAL32);
		retorno = retorno.round(new MathContext(3));;
		return retorno;

	}
	
	public BigDecimal calcularSuporte(String indicador1, String indicador2) throws IOException {
		Mineracao m = new Mineracao();
		BigDecimal qtdMarcadoresInd1 = new BigDecimal(m.getQtdMarcadores(indicador1));
		BigDecimal qtdMarcadoresInd2 = new BigDecimal(m.getQtdMarcadores(indicador2));
		BigDecimal totalQtdMarcadores = new BigDecimal(m.somaTotalQtdMarcadores());
		BigDecimal retorno = qtdMarcadoresInd1.add(qtdMarcadoresInd2).divide(totalQtdMarcadores, MathContext.DECIMAL32);
		retorno = retorno.round(new MathContext(3));;
		return retorno;

	}
	
	public void geraCalculoSuporteComTodosIndicadores() throws IOException{
		ManipuladorProperties manip = new ManipuladorProperties();
			try{
				int aux = 0;
				BufferedWriter StrW = new BufferedWriter(new FileWriter(manip.getArquivoCalculoSuporte()));
				String valor = "";
				for (int indicador1 = 1; indicador1 <= 59; indicador1++) {
					aux++;
					for (int indicador2 = 1; indicador2 <= 59; indicador2++) {
						if(indicador2 == 1){
							indicador2 += aux;
						}
						if(indicador2 <= 59){
							BigDecimal valorCalculo = calcularSuporte(""+indicador1,""+indicador2);
							valor = indicador1+", "+indicador2+", "+String.valueOf(valorCalculo);
							StrW.write(valor + "\n");
						}
					}
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
	
}
