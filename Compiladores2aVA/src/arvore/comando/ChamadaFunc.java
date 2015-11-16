package arvore.comando;

import java.util.List;

import arvore.expressao.Expressao;

public class ChamadaFunc implements Comando {
	private String nomeFuncao;
	private List<Expressao> listaExprs;
	
	public ChamadaFunc(String nomeFuncao, List<Expressao> listaExprs) {
		super();
		this.nomeFuncao = nomeFuncao;
		this.listaExprs = listaExprs;
	}
	public String getNomeFuncao() {
		return nomeFuncao;
	}
	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
	public List<Expressao> getListaExprs() {
		return listaExprs;
	}
	public void setListaExprs(List<Expressao> listaExprs) {
		this.listaExprs = listaExprs;
	}


	
}
