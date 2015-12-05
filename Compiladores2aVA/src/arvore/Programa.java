package arvore;

import java.util.ArrayList;
import java.util.List;

import gerador.Geravel;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;

public class Programa implements SemanticallyAnalyzable,Geravel {
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
		System.out.println("Não foram encontrados erros na Análise Semantica");
		return Tipo.VOID;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();

		sb.append(".class public "+o+"\n");
		sb.append(".super java/lang/Object \n\n");
		
		sb.append(".method public <init>()V\n");
		sb.append("aload_0\n");
		sb.append("invokenonvirtual java/lang/Object/<init>()V\n");
		sb.append("return\n");
		sb.append(".end method\n\n");
		
		for (DeclGlobal d : declaracoes) {
			sb.append(d.gerar(null));

		}
		return sb.toString();
	}

}
