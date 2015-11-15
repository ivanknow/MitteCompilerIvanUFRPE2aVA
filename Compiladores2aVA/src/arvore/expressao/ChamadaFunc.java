package arvore.expressao;

import java.util.List;

public class ChamadaFunc implements Expressao {
	private String escopo, retorno;
	private List<Expressao> listaExprs;
	private Identificador nomeFuncao;

	public ChamadaFunc(Identificador nomeFuncao, List<Expressao> listaExprs) {
		this.listaExprs = listaExprs;
		this.nomeFuncao = nomeFuncao;
	}

	public Identificador getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(Identificador nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}

	public String getEscopo() {
		return escopo;
	}

	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public List<Expressao> getListaExprs() {
		return listaExprs;
	}

	public void setListaExprs(List<Expressao> listaExprs) {
		this.listaExprs = listaExprs;
	}

}
