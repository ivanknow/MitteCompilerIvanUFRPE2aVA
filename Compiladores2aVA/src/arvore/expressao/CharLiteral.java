package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class CharLiteral implements Expressao {
	private String charLiteral;
	public CharLiteral(String charLiteral) {
		this.charLiteral = charLiteral;
	}
	@Override
	public Object analyse() throws SemanticalException {
		return Tipo.CHAR;
	}
}
