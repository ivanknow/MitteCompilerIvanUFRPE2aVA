package arvore;

import java.util.ArrayList;
import java.util.List;

import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;

public class Programa implements SemanticallyAnalyzable {
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

	@Override
	public String toString() {
		return "Programa [declaracoes=" + declaracoes + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		for (DeclGlobal d : declaracoes) {
			d.analyse();

		}

		return Boolean.TRUE;
	}

}
