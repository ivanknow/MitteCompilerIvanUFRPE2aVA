package arvore.expressao;

import java.util.List;

import semantica.SemanticalException;

public class ChamadaFuncErrado implements Expressao {
	private String escopo, retorno;
	private List<Expressao> listaExprs;
	private Identificador nomeFuncao;

	public ChamadaFuncErrado(Identificador nomeFuncao, List<Expressao> listaExprs) {
		this.listaExprs = listaExprs;
		this.nomeFuncao = nomeFuncao;
	}

	@Override
	public Object analyse() throws SemanticalException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
