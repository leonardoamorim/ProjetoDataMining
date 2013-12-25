package br.com.weka.comparator;

import java.util.Comparator;


import br.com.weka.model.TuplaRankingIndicador;

public class TuplaRankingIndicadorComparator implements Comparator<TuplaRankingIndicador>{


	@Override
	public int compare(TuplaRankingIndicador o1, TuplaRankingIndicador o2) {
		TuplaRankingIndicador t1 = o1;
		TuplaRankingIndicador t2 = o2;
		
		return -t1.getSomaLinha().compareTo(t2.getSomaLinha());
	}

}
