package arvore.expressao;

import semantica.SemanticalException;

public class ExpUnaria implements Expressao{
	private Expressao expr;
	private String operacao;
	
	public ExpUnaria(String operacao,Expressao expr){
		this.operacao = operacao;
		this.expr = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
