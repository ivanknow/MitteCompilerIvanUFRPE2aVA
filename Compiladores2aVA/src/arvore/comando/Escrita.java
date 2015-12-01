package arvore.comando;

import arvore.Tipo;
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
		expressao.analyse();
		return Tipo.VOID;
	}
	
	
}
