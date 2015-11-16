package arvore;

import java.util.List;

import arvore.expressao.Identificador;

public class DeclVariavel implements DeclGlobal {
	String tipo;
	List<Identificador> ident;
	
	
	public DeclVariavel(String tipo, List<Identificador> ident) {
		
		this.tipo = tipo;
		this.ident = ident;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Identificador> getIdent() {
		return ident;
	}
	public void setIdent(List<Identificador> ident) {
		this.ident = ident;
	}

	
	
}
