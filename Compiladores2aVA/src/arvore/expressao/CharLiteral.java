package arvore.expressao;

import semantica.SemanticalException;

public class CharLiteral implements Expressao {
	private String charLiteral;
	public CharLiteral(String charLiteral) {
		this.charLiteral = charLiteral;
	}
	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
}
