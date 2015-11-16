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

	public List<DeclGlobal> getDeclaracoes() {
		return declaracoes;
	}

	public void setDeclaracoes(List<DeclGlobal> declaracoes) {
		this.declaracoes = declaracoes;
	}
	
	

}
