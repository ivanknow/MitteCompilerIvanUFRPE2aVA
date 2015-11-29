package arvore.comando;

import java.util.List;

import arvore.Tipo;
import arvore.expressao.Expressao;
import semantica.SemanticFunctionItem;
import semantica.SemanticalException;
import semantica.TabelaEscopo;

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

	@Override
	public Object analyse() throws SemanticalException {
		// TODO verifica se funcao existe
		// verifica parametros

		TabelaEscopo tabela = TabelaEscopo.getInstance();
		SemanticFunctionItem s = (SemanticFunctionItem) tabela.getType(nomeFuncao);
		if (s.param.size() != listaExprs.size()) {
			throw new SemanticalException("Numero de parametros da fun��o n�o batem");
		}
		for (int i = 0; i < s.param.size(); i++) {
			if (s.param.get(i) != listaExprs.get(i).analyse()) {
				throw new SemanticalException("Tipo do parametros " + i + " nao bate");
			}

		}

		return s.tipo;// retorno vem da tabela
	}

}
