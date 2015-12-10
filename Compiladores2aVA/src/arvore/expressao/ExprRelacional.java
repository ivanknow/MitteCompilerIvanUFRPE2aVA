package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExprRelacional implements Expressao {

	private Expressao expr;
	private Expressao expr2;
	private String operador;
	Tipo tipoE1;
	Tipo tipoE2;

	public ExprRelacional(Expressao expr, Expressao expr2, String operador) {
		this.expr = expr;
		this.expr2 = expr2;
		this.operador = operador;
	}

	@Override
	public String toString() {
		return "\nExprRelacional [expr=" + expr + ", expr2=" + expr2 + ", operador=" + operador + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {

		tipoE1 = (Tipo) expr.analyse();
		tipoE2 = (Tipo) expr2.analyse();
		/*
		 * "==" OP_IGUAL "!=" OP_DIFERENTE ">" OP_MAIOR_QUE "<" OP_MENOR_QUE
		 * ">=" OP_MAIOR_OU_IGUAL "<=" OP_MENOR_OU_IGUAL)
		 */
		switch (tipoE1) {
		case CHAR:
			if (!(operador == "OP_IGUAL" || operador == "OP_DIFERENTE")) {

				String msg = "Tipo CHAR só é permitido em operações relacionais de igualdade";

				throw new SemanticalException(msg);

			} else {
				if (tipoE2 != Tipo.CHAR) {
					String msg = "Tipo CHAR só permite operações relacionais com Tipos CHAR";
					throw new SemanticalException(msg);
				}
			}
			break;
		case INT:
			if (tipoE2 != Tipo.INT) {
				String msg = "Tipo INT só permite operações relacionais com Tipo INT";
				throw new SemanticalException(msg);
			}
			break;
		case FLOAT:
			if (tipoE2 != Tipo.FLOAT) {
				String msg = "Tipo FLOAT só permite operações relacionais com Tipos FLOAT";
				throw new SemanticalException(msg);
			}
			break;
		default:
			throw new SemanticalException("Tipo de operandos não são permitidos para operações relacional:" + tipoE1);

		}
		return Tipo.BOOLEAN;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder retorno = new StringBuilder();
		retorno.append(expr.gerar(null));
		retorno.append(expr2.gerar(null));
		if (tipoE1 == Tipo.INT || tipoE1 == Tipo.CHAR) {
			retorno.append("icmp");
		} else {
			retorno.append("fcmp");
		}
		switch (operador) {
		case "OP_IGUAL":
			retorno.append("eq");
			break;
		case "OP_DIFERENTE":
			retorno.append("ne");
			break;

		case "OP_MAIOR_QUE":
			retorno.append("gt");
			break;
		case "OP_MENOR_QUE":
			retorno.append("lt");
			break;
		case "OP_MAIOR_OU_IGUAL":
			retorno.append("ge");
			break;

		case "OP_MENOR_OU_IGUAL":
			retorno.append("le");
			break;

		}
		return retorno.toString()+"\n";
	}

}
