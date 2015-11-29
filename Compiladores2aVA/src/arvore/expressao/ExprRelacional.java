package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExprRelacional implements Expressao {

	private Expressao expr;
	private Expressao expr2;
	private String operador;

	public ExprRelacional(Expressao expr, Expressao expr2) {
		this.expr = expr;
		this.expr2 = expr2;
	}

	@Override
	public String toString() {
		return "\nExprRelacional [expr=" + expr + ", expr2=" + expr2 + ", operador=" + operador + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		// tratar se tipo eh int ou float
		if (expr.analyse() != Tipo.INT && expr.analyse() != Tipo.FLOAT) {
			throw new SemanticalException("Relacionais devem ser aplicadas apenas a INT e FLOAT");
		}
		if (expr2.analyse() != Tipo.INT && expr2.analyse() != Tipo.FLOAT) {
			throw new SemanticalException("Relacionais devem ser aplicadas apenas a INT e FLOAT");
		}
		if (expr.analyse() !=  expr2.analyse()) {
			throw new SemanticalException("Tipos dos operandos diferem");
		}
		return Tipo.BOOLEAN;
	}

}
