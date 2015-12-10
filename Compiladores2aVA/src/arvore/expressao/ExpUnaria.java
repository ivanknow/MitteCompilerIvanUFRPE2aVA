package arvore.expressao;

import arvore.Tipo;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class ExpUnaria implements Expressao {
	private Expressao expr;
	private String operacao;
	private Tipo tipoexp;

	public ExpUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		tipoexp = (Tipo)expr.analyse();
		if (operacao.equals("NOT")) {
			if (tipoexp != Tipo.BOOLEAN) {
				throw new SemanticalException("Operador NOT suporta apenas entradas BOOLEAN");
			}
			return Tipo.BOOLEAN;
		} else {// OP == "-"
			if (tipoexp != Tipo.INT && tipoexp != Tipo.FLOAT) {
				throw new SemanticalException("Operador '-' suporta apenas entradas NUMERICAS");
			}
			return expr.analyse();
		}

	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(expr.gerar(null));
		
		if (operacao.equals("NOT")) {
			sb.append(GerarCodigo.tradutorTipos(tipoexp, "neg")+"\n");
		}else{
			
			sb.append(GerarCodigo.tradutorTipos(tipoexp, "neg")+"\n");
		}
		
		return sb.toString();
	}

}
