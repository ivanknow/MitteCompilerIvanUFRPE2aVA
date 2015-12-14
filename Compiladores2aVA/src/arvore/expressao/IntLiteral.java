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
	public String gerar(Object o) {
		
		return "bipush "+intLiteral+"\n" ;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.INT;
	}

	@Override
	public void setTipo(Tipo t) {
		// TODO Auto-generated method stub
		
	}

}
