package arvore.expressao;


public class ExpLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;
	
	
	public ExpLogica(Expressao e1, Expressao e2, String oper){
	this.exp1 = e1;
	this.exp2 = e2;
	this.operLogico = oper;
	}
	
}
