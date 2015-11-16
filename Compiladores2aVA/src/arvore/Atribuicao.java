package arvore;

import java.util.List;

import arvore.comando.Comando;
import arvore.expressao.Expressao;
import arvore.expressao.Identificador;

public class Atribuicao implements Comando{
	private List<Identificador> listaIdents;
	private Expressao expressao;
	public Atribuicao(List<Identificador> listaIdents, Expressao expressao) {
		super();
		this.listaIdents = listaIdents;
		this.expressao = expressao;
	}
	

	
}
