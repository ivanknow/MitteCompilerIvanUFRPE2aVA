package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class IntLiteral implements Expressao{
	private Integer intLiteral;

	public IntLiteral(Integer intLiteral) {
		super();
		this.intLiteral = intLiteral;
	}

	@Override
	public Object analyse() throws SemanticalException {
		return Tipo.INT;
	}
	

}
