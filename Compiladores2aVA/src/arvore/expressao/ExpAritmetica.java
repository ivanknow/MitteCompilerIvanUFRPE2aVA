package arvore.expressao;

import semantica.SemanticalException;

public class ExpAritmetica implements Expressao{

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;
	
	public ExpAritmetica(Expressao exp1,Expressao exp2,String operacao){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}

	@Override
	public String toString() {
		return "ExpAritmetica [exp1=" + exp1 + ", exp2=" + exp2 + ", operacao=" + operacao + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
