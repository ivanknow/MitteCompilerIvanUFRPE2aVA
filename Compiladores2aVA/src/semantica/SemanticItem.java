package semantica;

import arvore.Tipo;

public class SemanticItem {
	public Tipo tipo;
	public int idEscopo;
	public SemanticItem(Tipo tipo) {
		super();
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "SemanticItem [tipo=" + tipo + "]";
	}
	
}
