package arvore.expressao;

import arvore.Tipo;
import semantica.SemanticalException;

public class FloatLiteral implements Expressao {
	float f;
	public FloatLiteral(Float f) {
		this.f=f;
	}
	@Override
	public Object analyse() throws SemanticalException {
		
		return Tipo.FLOAT;
	}
}
