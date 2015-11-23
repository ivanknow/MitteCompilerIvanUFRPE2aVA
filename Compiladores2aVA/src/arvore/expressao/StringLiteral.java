package arvore.expressao;

import semantica.SemanticalException;

public class StringLiteral implements Expressao {
	
	private String stringLiteral;
	
	public StringLiteral(String stringLiteral){
		this.stringLiteral = stringLiteral;
		
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}

}
