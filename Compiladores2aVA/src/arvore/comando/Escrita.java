package arvore.comando;

import arvore.expressao.Expressao;
import semantica.SemanticalException;

public class Escrita implements Comando {
	private Expressao expressao;

	public Escrita(Expressao expressao) {
		this.expressao = expressao;
	}

	@Override
	public String toString() {
		return "\n Escrita [expressao=" + expressao + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
