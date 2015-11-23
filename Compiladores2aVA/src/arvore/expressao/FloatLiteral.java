package arvore.expressao;

import semantica.SemanticalException;

public class FloatLiteral implements Expressao {
	float f;
	public FloatLiteral(Float f) {
		this.f=f;
	}
	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}
}
