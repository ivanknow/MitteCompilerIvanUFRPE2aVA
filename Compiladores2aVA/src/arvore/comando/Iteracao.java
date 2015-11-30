package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import semantica.SemanticalException;

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
	@Override
	public Object analyse() throws SemanticalException {
		Tipo tipoExp = (Tipo)expressao.analyse();
		if(tipoExp != Tipo.BOOLEAN){
			throw new SemanticalException("Condicao do la�o deve ser BOOLEAN");
		}
		;
		return comando.analyse();
	}
	
	
	
	
}
