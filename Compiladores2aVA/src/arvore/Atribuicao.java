package arvore;

import java.util.List;

import arvore.comando.Comando;
import arvore.expressao.Expressao;

public class Atribuicao implements Comando{
	private List<String> listaIdents;
	private Expressao expressao;
	public Atribuicao(List<String> listaIdents, Expressao expressao) {
		super();
		this.listaIdents = listaIdents;
		this.expressao = expressao;
	}
	

	
}
