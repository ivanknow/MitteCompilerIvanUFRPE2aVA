package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExpAritmetica implements Expressao {

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;
	Tipo tipoE1;
	Tipo tipoE2;

	public ExpAritmetica(Expressao exp1, Expressao exp2, String operacao) {
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
		tipoE1 = (Tipo) exp1.analyse();
		tipoE2 = (Tipo) exp2.analyse();

		switch (tipoE1) {
		case CHAR:
			if (!(operacao == "SOMA" || operacao == "SUB")) {
				// se for diferente de soma ou sub
				String msg = "Tipo CHAR s� � permitido em opera��es de soma ou subitra��o";
				throw new SemanticalException(msg);
			} else {
				if (tipoE2 != Tipo.INT) {
					String msg = "Tipo CHAR s� permite opera��es com Tipos INT";
					throw new SemanticalException(msg);
				}
			}
			break;
		case INT:
			if (tipoE2 != Tipo.INT) {
				String msg = "Tipo INT s� permite opera��es com Tipos INT";
				throw new SemanticalException(msg);
			}
			break;
		case FLOAT:
			if (tipoE2 != Tipo.FLOAT) {
				String msg = "Tipo FLOAT s� permite opera��es com Tipos FLOAT";
				throw new SemanticalException(msg);
			}
			break;
		default:
			throw new SemanticalException("Tipo de operandos n�o s�o permitidos para opera��es aritmeticas:" + tipoE1);

		}
		return tipoE1;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder retorno = new StringBuilder();
		retorno.append(exp1.gerar(null));
		retorno.append(exp2.gerar(null));
		if (tipoE1 == Tipo.INT || tipoE1 == Tipo.CHAR) {
			retorno.append("i");
		} else {
			retorno.append("f");
		}
		switch (operacao) {
		case "SOMA":
			retorno.append("add");
			break;
		case "SUB":
			retorno.append("sub");
			break;

		case "MULT":
			retorno.append("mul");
			break;
		case "DIV":
			retorno.append("div");
			break;
		case "RESTO":
			retorno.append("rem");
			break;

		}
		return retorno.toString()+"\n";
	}

}
