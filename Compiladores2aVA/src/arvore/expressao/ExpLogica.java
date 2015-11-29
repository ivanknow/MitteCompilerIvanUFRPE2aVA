package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExpLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;
	
	
	public ExpLogica(Expressao e1, Expressao e2, String oper){
	this.exp1 = e1;
	this.exp2 = e2;
	this.operLogico = oper;
	}


	@Override
	public String toString() {
		return "\nExpLogica [exp1=" + exp1 + ", exp2=" + exp2 + ", operLogico=" + operLogico + "]";
	}


	@Override
	public Object analyse() throws SemanticalException {
		//tratar se tipo eh boolean
		Tipo tipoE1 = (Tipo) exp1.analyse();
		Tipo tipoE2 = (Tipo) exp2.analyse();
		
		if (tipoE1!= Tipo.BOOLEAN || tipoE2 != Tipo.BOOLEAN) {
			throw new SemanticalException("Relacionais devem ser aplicadas apenas a INT e FLOAT");
		}
		return Tipo.BOOLEAN;
	}
	
}
