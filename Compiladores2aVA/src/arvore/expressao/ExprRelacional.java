package arvore.expressao;

import semantica.SemanticalException;

public class ExprRelacional implements Expressao {
	
	private Expressao expr;
	private Expressao expr2;
	private String operador;
	
	public ExprRelacional(Expressao expr, Expressao expr2){
		this.expr = expr;
		this.expr2 = expr2;
	}

	@Override
	public String toString() {
		return "\nExprRelacional [expr=" + expr + ", expr2=" + expr2 + ", operador=" + operador + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
