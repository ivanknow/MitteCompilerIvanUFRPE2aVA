package arvore.comando;

import arvore.expressao.Expressao;

public class Escrita implements Comando {
	private Expressao expressao;

	public Escrita(Expressao expressao) {
		this.expressao = expressao;
	}
}
