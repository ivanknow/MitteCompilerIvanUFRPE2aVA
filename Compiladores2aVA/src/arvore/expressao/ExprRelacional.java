package arvore.expressao;

import arvore.Tipo;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class ExprRelacional implements Expressao {

	private Expressao expr;
	private Expressao expr2;
	private String operador;
	Tipo tipoE1;
	Tipo tipoE2;
	Tipo retorno;

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
			retorno = Tipo.CHAR;
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
			retorno = Tipo.INT;
			if (tipoE2 != Tipo.INT) {
				String msg = "Tipo INT só permite operações relacionais com Tipo INT";
				throw new SemanticalException(msg);
			}
			break;
		case FLOAT:
			retorno = Tipo.FLOAT;
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
			retorno.append("if_icmp");
			/*
			 if_icmpne else
			 bipush 1
			 goto fim
			 else:
			 bipush 0
			 fim:
			 */
			int label = GerarCodigo.getLabelCount();
			switch (operador) {
			case "OP_IGUAL":
				retorno.append("ne");
				break;
			case "OP_DIFERENTE":
				retorno.append("eq");
				break;

			case "OP_MAIOR_QUE":
				retorno.append("le");
				break;
			case "OP_MENOR_QUE":
				retorno.append("ge");
				break;
			case "OP_MAIOR_OU_IGUAL":
				retorno.append("lt");
				break;

			case "OP_MENOR_OU_IGUAL":
				retorno.append("gt");
				break;

			}
			
			retorno.append(" else"+label+"\n");
			retorno.append("bipush 1\n");
			retorno.append("goto fim"+label+"\n");
			retorno.append("else"+label+":\n");
			retorno.append("bipush 0\n");
			retorno.append("fim"+label+":\n");
			
		} else {
			retorno.append("fcmpg");
			//-1 0 1
			//bipush 0
			//if_icmpeq
			switch (operador) {
			case "OP_IGUAL":
				retorno.append("bipush 0\n");
				
				break;
			case "OP_DIFERENTE":
				retorno.append("eq");
				break;

			case "OP_MAIOR_QUE":
				retorno.append("le");
				break;
			case "OP_MENOR_QUE":
				retorno.append("ge");
				break;
			case "OP_MAIOR_OU_IGUAL":
				retorno.append("lt");
				break;

			case "OP_MENOR_OU_IGUAL":
				retorno.append("gt");
				break;

			}
			
		}
		
		return retorno.toString()+"\n";
	}

	@Override
	public Tipo getTipo() {
		
		return retorno;
	}

	@Override
	public void setTipo(Tipo t) {
		retorno = t;
		
	}

}
