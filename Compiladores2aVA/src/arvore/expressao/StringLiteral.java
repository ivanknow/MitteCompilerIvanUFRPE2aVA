package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class StringLiteral implements Expressao {
	
	private String stringLiteral;
	
	public StringLiteral(String stringLiteral){
		this.stringLiteral = stringLiteral;
		
	}

	@Override
	public Object analyse() throws SemanticalException {
		
		return Tipo.STRING;
	}

}
