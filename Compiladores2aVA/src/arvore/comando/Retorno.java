package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import semantica.SemanticalException;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		Tipo tipoExp = (Tipo)expressao.analyse();
		
		if(tipoExp == Tipo.VOID){
			throw new SemanticalException("Nao é possivel retornar VOID");
		}
		return tipoExp;
	}
	
}
