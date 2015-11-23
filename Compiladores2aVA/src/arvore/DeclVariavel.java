package arvore;

import java.util.List;

import arvore.expressao.Identificador;
import semantica.SemanticalException;

public class DeclVariavel implements DeclGlobal {
	Tipo tipo;
	List<Identificador> ident;

	public DeclVariavel(Tipo tipo, List<Identificador> ident) {

		this.tipo = tipo;
		this.ident = ident;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Identificador> getIdent() {
		return ident;
	}

	public void setIdent(List<Identificador> ident) {
		this.ident = ident;
	}

	@Override
	public String toString() {
		return "\nDeclVariavel [tipo=" + tipo + ", ident=" + ident + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}

}
