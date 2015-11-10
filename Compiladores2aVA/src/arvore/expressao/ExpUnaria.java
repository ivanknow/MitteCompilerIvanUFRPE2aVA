package arvore.expressao;


public class ExpUnaria implements Expressao{
	private Expressao expr;
	private String operacao;
	
	public ExpUnaria(String operacao,Expressao expr){
		this.operacao = operacao;
		this.expr = expr;
	}
	
}
