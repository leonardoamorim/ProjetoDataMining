package br.com.weka.mineracao;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

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
	
}
