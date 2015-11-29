package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExpUnaria implements Expressao {
	private Expressao expr;
	private String operacao;

	public ExpUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		if (operacao.equals("NOT")) {
			if (expr.analyse() != Tipo.BOOLEAN) {
				throw new SemanticalException("Operador NOT suporta apenas entradas BOOLEAN");
			}
			return Tipo.BOOLEAN;
		} else {// OP == "-"
			if (expr.analyse() != Tipo.INT && expr.analyse() != Tipo.FLOAT) {
				throw new SemanticalException("Operador '-' suporta apenas entradas NUMERICAS");
			}
			return expr.analyse();
		}

	}

}
