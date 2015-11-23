package arvore;

import java.util.List;

import arvore.comando.Comando;
import arvore.expressao.Expressao;
import arvore.expressao.Identificador;
import semantica.SemanticalException;

public class Atribuicao implements Comando{
	private List<Identificador> listaIdents;
	private Expressao expressao;
	public Atribuicao(List<Identificador> listaIdents, Expressao expressao) {
		super();
		this.listaIdents = listaIdents;
		this.expressao = expressao;
	}
	@Override
	public String toString() {
		return "\nAtribuicao [listaIdents=" + listaIdents + ", expressao=" + expressao + "]";
	}
	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
