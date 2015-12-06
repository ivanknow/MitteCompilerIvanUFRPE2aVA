package arvore;

import java.util.List;

import arvore.expressao.Identificador;
import semantica.SemanticItem;
import semantica.SemanticalException;
import semantica.TabelaEscopo;

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
		TabelaEscopo t = TabelaEscopo.getInstance();
		for (Identificador i : ident) {

			i.setIdEscopo(t.addItem(i.getLabel(), new SemanticItem(tipo)));

		}
		return Tipo.VOID;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}

}
