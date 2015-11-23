package arvore.expressao;

import semantica.SemanticalException;

public class IntLiteral implements Expressao{
	private Integer intLiteral;

	public IntLiteral(Integer intLiteral) {
		super();
		this.intLiteral = intLiteral;
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
