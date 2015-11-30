package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class ExpAritmetica implements Expressao {

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;

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
		Tipo tipoE1 = (Tipo) exp1.analyse();
		Tipo tipoE2 = (Tipo) exp2.analyse();

		switch (tipoE1) {
		case CHAR:
			if (!(operacao == "SOMA" || operacao == "SUB")) {
				// se for diferente de soma ou sub
				String msg = "Tipo CHAR só é permitido em operações de soma ou subitração";
				throw new SemanticalException(msg);
			}else{
				if(tipoE2!=Tipo.INT){
					String msg = "Tipo CHAR só permite operações com Tipos INT";
					throw new SemanticalException(msg);
				}
			}
			break;
		case INT:
			if(tipoE2!=Tipo.INT){
				String msg = "Tipo INT só permite operações com Tipos INT";
				throw new SemanticalException(msg);
			}
			break;
		case FLOAT:
			if(tipoE2!=Tipo.FLOAT){
				String msg = "Tipo FLOAT só permite operações com Tipos FLOAT";
				throw new SemanticalException(msg);
			}
			break;
		default:
			throw new SemanticalException("Tipo de operandos não são permitidos para operações aritmeticas:" + tipoE1);

		}
		return tipoE1;
	}

}
