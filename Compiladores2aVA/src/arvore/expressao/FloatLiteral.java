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
	
	public String gerar(Object o) {
		
		return "ldc "+f+"\n" ;
	}
	@Override
	public Tipo getTipo() {

		return Tipo.FLOAT;
	}
	@Override
	public void setTipo(Tipo t) {
		// TODO Auto-generated method stub
		
	}
}
