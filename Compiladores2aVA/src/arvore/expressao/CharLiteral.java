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
	@Override
	public String gerar(Object o) {
	
		return "bipush "+charLiteral+"\n" ;
	}
	@Override
	public Tipo getTipo() {
	
		return Tipo.CHAR;
	}
	@Override
	public void setTipo(Tipo t) {
		// TODO Auto-generated method stub
		
	}
}
