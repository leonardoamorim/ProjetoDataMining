package br.com.weka.cluster;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class ClusterizacaoEspacial {

	public void clusterizar(String arquivoOrigem, String arquivoDestino)  throws Exception{
		FileReader reader = new FileReader(arquivoOrigem);
	    Instances instancias = new Instances(reader);
	    
	    /* Para clusterizacao espacial usando a interface grafica do Weka 
	     * considerando apenas os atributos coordenada x e y eh necessario
	     * ignorar todos os atributos exceto os atributos de coordenadas;
	     * 
	     * O arquivo CSV ou ARFF possui originalmente 12 atributos:
	     * 1 - id_usuario
	     * 2 - marcador
	     * 3 - tipo_marcador
	     * 4 - ano
	     * 5 - mes
	     * 6 - semana
	     * 7 - dia
	     * 8 - hora
	     * 9 - minuto
	     * 10 - segundo
	     * 11 - coordenada_x
	     * 12 - coordenada_y
	     * 
	     * Portanto, eh necessario ignorar os atributos de 1 a 10
	     * A API do Weka sugere que seja criado um vetor de String
	     * onde a posicao ZERO guarda o parametro -R que define o RANGE (intervalo)
	     * e na posicao UM eh guardado todos os atributos que serao ignorados
	     * 
	     */
	    String[] opcoes = new String[2];
	    opcoes[0] = "-R";  // range                                  
	    opcoes[1] = "1,2,3,4,5,6,7,8,9,10"; // deixando apenas os atributos de coordenadas
	    Remove remove = new Remove();       // instanciando o filtro
	    remove.setOptions(opcoes);          // setando as opcoes
	    remove.setInputFormat(instancias);  // informando o filtro sobre a base de dados apos setar as opcoes
	    
	    // Abaixo eh criado uma nova instancia que guardara o resultado do filtro com o intuito
	    // de preservar o valor de instancias que sera usado logo a frente no codigo
	    Instances newData = Filter.useFilter(instancias, remove);   // aplicando o filtro
	    
	    // Criamos o agrupamento usando o algoritmo SimpleKMeans com metodo de distancia Euclidiana
	    SimpleKMeans agrupamento = new SimpleKMeans();
		EuclideanDistance ed = new EuclideanDistance();
		
		//Definindo como sera feita a clusterizacao
	    agrupamento.setNumClusters(100); // Numero de clusters (100 espaciais)
	    
	    // Configuracoes padroes da interface grafica do Weka
	    agrupamento.setDisplayStdDevs(true);
		String[] options = new String[2]; // Funcao de distancia
		options[0] = "-R"; // Funcao de distancia
		options[1] = "first-last"; // Funcao de distancia
		agrupamento.setPreserveInstancesOrder(false); // Nao preserva ordem das instancias
		agrupamento.setDistanceFunction(ed); // Usar metodo de distancia euclidiana
		agrupamento.setMaxIterations(500); //Numero maximo de iteracoes
		agrupamento.setSeed(10);  //Setar semente (valor padrao Weka)
		agrupamento.setDontReplaceMissingValues(false); //Nao substituir valores faltantes (valor padrao Weka)
		agrupamento.setOptions(options); //Setando Funcao de distancia
	    agrupamento.buildClusterer(newData); // Clusterizando as instancias filtradas (apenas as coordenadas x e y)
	    // Mostramos estatisticas sobre o agrupamento.
	    Instances clusterCenters = agrupamento.getClusterCentroids(); //Nao esta em uso, mas pode ser usado par aobter as centroides
	    Instances clusterSTDDEVs = agrupamento.getClusterStandardDevs(); //Nao esta em uso, mas pode ser usado para obter os resultados que aparecem na saida padrao do Weka na interface grafica
	    int[] clusterSizes = agrupamento.getClusterSizes(); //Nao esta em uso, mas obtem o tamanho de cada cluster
	    

	    StringBuffer textoBuffer = new StringBuffer();
	    
	    // Aqui eh mostrado a que cluster pertence cada instancia
	    // E o resultado eh descarregado em um arquivo
	    for(int inst=0;inst<newData.numInstances();inst++)
	    {
	    	Instance instancia = newData.instance(inst);
	    	Instance teste = instancias.instance(inst);
	        int cluster = (int)(agrupamento.clusterInstance(instancia));
	        textoBuffer.append(inst+","+teste+","+cluster + " \n");	
	    }
	    
	    try {  
            FileOutputStream oStream = new FileOutputStream(arquivoDestino); // ou usando um File com argumento  
            OutputStreamWriter osw = new OutputStreamWriter(oStream);  
            Writer writer = new BufferedWriter(osw);  
            writer.write(textoBuffer.toString());  
  
            writer.flush();  
            writer.close();  
            System.out.println("Clusterizacao Espacial realizada com sucesso!");
        } catch (Exception e) {  
        	System.out.println("Falha na clusterizacao Espacial!");
            e.printStackTrace();  
        } 
	}
}
