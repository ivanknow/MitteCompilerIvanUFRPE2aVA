package semantica;

import java.util.ArrayList;
import java.util.List;

import arvore.Tipo;

public class SemanticFunctionItem extends SemanticItem {
	public List<Tipo> param;

	public SemanticFunctionItem(Tipo tipo, List<Tipo> param) {
		super(tipo);
		this.param = param;
	}

	public SemanticFunctionItem(Tipo tipo) {
		super(tipo);
		this.param = new ArrayList<Tipo>();
	}

	@Override
	public String toString() {
		return "SemanticFunctionItem [param=" + param + "][tipo=" + tipo + "]";
	}

}
