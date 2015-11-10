package arvore.expressao;


public class ExpAritmetica implements Expressao{

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;
	
	public ExpAritmetica(Expressao exp1,Expressao exp2,String operacao){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}
	
	
}
