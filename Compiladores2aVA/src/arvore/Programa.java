package arvore;

import java.util.ArrayList;
import java.util.List;

public class Programa {
	private List<DeclGlobal> declaracoes;
	
	public Programa() {
		declaracoes = new ArrayList<>();
	}
	
	public void add(DeclGlobal dec) {
		this.declaracoes.add(dec);
	}

}
