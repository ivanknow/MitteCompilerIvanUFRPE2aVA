package arvore.comando;

import arvore.expressao.Expressao;

public class Iteracao implements Comando {
	
	private Expressao expressao;
	private Comando comando;
	public Iteracao(Expressao expressao, Comando comando) {
		super();
		this.expressao = expressao;
		this.comando = comando;
	}
	@Override
	public String toString() {
		return "\n Iteracao [expressao=" + expressao + ", comando=" + comando + "]";
	}
	
	
	
	
}
