package br.com.weka.cluster;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import br.com.weka.manipulador.Manipulador;
import br.com.weka.model.Estatistica;

public class ClusterizacaoTemporal {
	
	private List<String[]> lista = new ArrayList<String[]>();
	
	public ClusterizacaoTemporal(String caminhoDoArquivo) throws IOException {  
	    File arquivoCSV = new File(caminhoDoArquivo);  
	    FileReader fr = new FileReader(arquivoCSV);  
	    BufferedReader br = new BufferedReader(fr);  
	                     
	    String linha;  
	    while ((linha = br.readLine()) != null) {  
	        String registro[] = linha.split(",");  
	        lista.add(registro);  
	    } 
    }
	
	public ClusterizacaoTemporal(){
		
	}

	public void clusterizar()  throws Exception{
		for (int i=0; i <= 99; i++) {
				Manipulador manip = new Manipulador();
				FileReader reader = new FileReader(manip.getDiretorioClustersEspaciais()+"clusterizacao_espacial"+i+".arff");
			    Instances instancias = new Instances(reader);
			    /* Para clusterizacao temporal usando a interface grafica do Weka 
			     * considerando apenas o atributo de tempo (dia) eh necessario
			     * ignorar todos os atributos exceto o atributo dia;
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
			     * Portanto, eh necessario ignorar os atributos de 1 a 6 e de 8 a 12
			     * A API do Weka sugere que seja criado um vetor de String
			     * onde a posicao ZERO guarda o parametro -R que define o RANGE (intervalo)
			     * e na posicao UM eh guardado todos os atributos que serao ignorados
			     * 
			     */
			    
			    String[] opcoes = new String[2];
			    opcoes[0] = "-R"; // range                                    
			    opcoes[1] = "1,2,3,4,5,6,8,9,10,11,12"; // deixando apenas os atributos dia (numero 7)
			    Remove remove = new Remove(); // instanciando o filtro                    
			    remove.setOptions(opcoes); // setando as opcoes                    
			    remove.setInputFormat(instancias); // informando o filtro sobre a base de dados apos setar as opcoes        
			    
			    // Abaixo eh criado uma nova instancia que guardara o resultado do filtro com o intuito
			    // de preservar o valor de instancias que sera usado logo a frente no codigo
			    Instances newData = Filter.useFilter(instancias, remove);  // aplicando o filtro
		
			    // Criamos o agrupamento usando o algoritmo SimpleKMeans com metodo de distancia Euclidiana
			    SimpleKMeans agrupamento = new SimpleKMeans(); 
				EuclideanDistance ed = new EuclideanDistance();
				
				//Definindo como sera feita a clusterizacao
			    agrupamento.setNumClusters(10); //Sao criados 10 clusters considerando apenas 1 mes (30 dias), o intervalo sera de mais ou menos 3 em 3 dias
			    
			    // Configuracoes padroes da interface grafica do Weka
			    agrupamento.setDisplayStdDevs(true);
				String[] options = new String[2]; // Funcao de distancia
				options[0] = "-R"; // Funcao de distancia
				options[1] = "first-last"; // Funcao de distancia
				agrupamento.setPreserveInstancesOrder(false); // Nao preserva ordem das instancias
				agrupamento.setDistanceFunction(ed); // Usar metodo de distancia euclidiana
				agrupamento.setMaxIterations(500); //Numero maximo de iteracoes
				agrupamento.setSeed(10); //Setar semente (valor padrao Weka)
				agrupamento.setDontReplaceMissingValues(false); //Nao substituir valores faltantes (valor padrao Weka)
				agrupamento.setOptions(options); // Setando Funcao de distancia
			    agrupamento.buildClusterer(newData); // Clusterizando as instancias filtradas (apenas o atributo dia)
			    
			    StringBuffer textoBuffer = new StringBuffer();
			    
			    // Aqui eh mostrado a que cluster pertence cada instancia
			    // E o resultado eh descarregado em um arquivo
			    for(int inst=0;inst<newData.numInstances();inst++)
			    {
			    	Instance instancia = newData.instance(inst);
			    	Instance teste = instancias.instance(inst);
			        int cluster = (int)(agrupamento.clusterInstance(instancia));
			        textoBuffer.append(teste+","+cluster + " \n");	
			    }
			    
			    try {
		            FileOutputStream oStream = new FileOutputStream(manip.getDiretorioClustersTemporais()+"clusterizacao_temporal_"+i+".arff"); // ou usando um File com argumento  
		            OutputStreamWriter osw = new OutputStreamWriter(oStream);  
		            Writer writer = new BufferedWriter(osw);  
		            writer.write(textoBuffer.toString());  
		  
		            writer.flush();  
		            writer.close();  
		            System.out.println("Arquivo clusterizacao_temporal_"+i+".arff - Sucesso");
		        } catch (Exception e) {  
		        	System.out.println("Arquivo clusterizacao_temporal_"+i+".arff - Erro");
		            e.printStackTrace();  
		        } 
		}
		System.out.println("---------------- Criado Arquivos ------------------");
	}

    
    
    public List<Estatistica> getListaEstatistica(){
    	List<Estatistica> estatisticas = new ArrayList<Estatistica>();
    	if (lista.size() > 0) {  
            for (int i = 1; i < lista.size(); i++) {  
                Estatistica estatistica = new Estatistica();
                estatistica.setIdUsuario(Integer.parseInt(lista.get(i)[0]));
                estatistica.setMarcador(lista.get(i)[1]);
                estatistica.setTipoMarcador(Integer.parseInt(lista.get(i)[2]));
                estatistica.setAno(Integer.parseInt(lista.get(i)[3]));
                estatistica.setMes(Integer.parseInt(lista.get(i)[4]));
                estatistica.setSemana(Integer.parseInt(lista.get(i)[5]));
                estatistica.setDia(Integer.parseInt(lista.get(i)[6]));
                estatistica.setHora(Integer.parseInt(lista.get(i)[7]));
                estatistica.setMinuto(Integer.parseInt(lista.get(i)[8]));
                estatistica.setSegundo(Integer.parseInt(lista.get(i)[9]));
                estatistica.setCoordenadaX(lista.get(i)[10]);
                estatistica.setCoordenadaY(lista.get(i)[11]);
                estatistica.setCluster(lista.get(i)[12]);
                estatisticas.add(estatistica);
            }  
        }  
    	return estatisticas;
    }
	
}
