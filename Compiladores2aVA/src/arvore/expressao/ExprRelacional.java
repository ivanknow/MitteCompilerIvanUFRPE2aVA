package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExprRelacional implements Expressao {

	private Expressao expr;
	private Expressao expr2;
	private String operador;

	public ExprRelacional(Expressao expr, Expressao expr2,String operador) {
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
		
		Tipo tipoE1 = (Tipo) expr.analyse();
		Tipo tipoE2 = (Tipo) expr2.analyse();
/*
"==" OP_IGUAL
"!=" OP_DIFERENTE
">" OP_MAIOR_QUE
"<" OP_MENOR_QUE
">=" OP_MAIOR_OU_IGUAL
"<=" OP_MENOR_OU_IGUAL)
*/
		switch (tipoE1) {
		case CHAR:
			if (!(operador == "OP_IGUAL" || operador == "OP_DIFERENTE")) {
				
				String msg = "Tipo CHAR s� � permitido em opera��es relacionais de igualdade";
				
				throw new SemanticalException(msg);
			
			}else{
				if(tipoE2!=Tipo.CHAR){
					String msg = "Tipo CHAR s� permite opera��es relacionais com Tipos CHAR";
					throw new SemanticalException(msg);
				}
			}
			break;
		case INT:
			if(tipoE2!=Tipo.INT){
				String msg = "Tipo INT s� permite opera��es relacionais com Tipo INT";
				throw new SemanticalException(msg);
			}
			break;
		case FLOAT:
			if(tipoE2!=Tipo.FLOAT){
				String msg = "Tipo FLOAT s� permite opera��es relacionais com Tipos FLOAT";
				throw new SemanticalException(msg);
			}
			break;
		default:
			throw new SemanticalException("Tipo de operandos n�o s�o permitidos para opera��es relacional:" + tipoE1);

		}
		return Tipo.BOOLEAN;
	}

}
