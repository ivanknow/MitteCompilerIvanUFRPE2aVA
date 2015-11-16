package arvore.comando;

import java.util.List;

import arvore.DeclGlobal;
import arvore.Tipo;


public class DeclVariavel3 implements Comando, DeclGlobal {
	private List<String> idents;
	private Tipo tipo;
	
	public DeclVariavel3(List<String> ids, Tipo t) {
		this.idents = ids;
		this.tipo = t;
	}
	
}
