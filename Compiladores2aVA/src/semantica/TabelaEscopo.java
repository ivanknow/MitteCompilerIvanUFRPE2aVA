package semantica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arvore.Tipo;

public class TabelaEscopo {
	private static TabelaEscopo instance;
	
	private ArrayList<Map<String,Tipo>> pilhaEscopo;

	static {
	
	}
	private TabelaEscopo() {
	}

	public static TabelaEscopo getInstance(){

		if(instance == null) 
		{
			inicializaInstancia();

		}
		return instance;

	}
	
	public Tipo getType (String label){
		//verifica a tabela de cima e depois a de baixo
		//caso encontre retorna caso não retora null ou excecao
		return null;
	}
	
	public void criaNovoEscopo (){
		//TODO armazena a função no escopo principal
		//cria novo escopo
		//adiciona parametros no novo escopo
	}
	
	public void removeEscopo(){
		instance.pilhaEscopo.remove(1);
	}

	private static synchronized void inicializaInstancia() 
	{
		if (instance == null) 
		{
			instance = new TabelaEscopo();
			instance.pilhaEscopo = new ArrayList<>();
			instance.pilhaEscopo.add(new HashMap<String,Tipo>());
		}
	}
}
