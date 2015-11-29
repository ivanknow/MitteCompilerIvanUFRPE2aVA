package arvore.expressao;

import arvore.Tipo;
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
		Tipo tipoE1 = (Tipo) exp1.analyse();
		Tipo tipoE2 = (Tipo) exp2.analyse();
		if (tipoE1 != Tipo.INT && tipoE1 != Tipo.FLOAT) {
			throw new SemanticalException("Aritmeticas devem ser aplicadas apenas a INT e FLOAT");
		}
		if (tipoE2 != Tipo.INT && tipoE2 != Tipo.FLOAT) {
			throw new SemanticalException("Aritmeticas devem ser aplicadas apenas a INT e FLOAT");
		}
		if (tipoE1 !=  tipoE2) {
			throw new SemanticalException("Tipos dos operandos diferem");
		}
		return tipoE1;
	}
	
	
}
