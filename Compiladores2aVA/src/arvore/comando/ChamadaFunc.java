package arvore.comando;

import java.util.List;

import arvore.Tipo;
import arvore.expressao.Expressao;
import gerador.GerarCodigo;
import semantica.SemanticFunctionItem;
import semantica.SemanticalException;
import semantica.TabelaEscopo;

public class ChamadaFunc implements Comando, Expressao {
	private String nomeFuncao;
	private List<Expressao> listaExprs;
	Tipo t;

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


		TabelaEscopo tabela = TabelaEscopo.getInstance();
		SemanticFunctionItem s = (SemanticFunctionItem) tabela.getType(nomeFuncao);
		if (s.param.size() != listaExprs.size()) {
			throw new SemanticalException("Numero de parametros da função não batem");
		}
		for (int i = 0; i < s.param.size(); i++) {
			if (s.param.get(i) != listaExprs.get(i).analyse()) {
				throw new SemanticalException("Tipo do parametros " + i + " nao bate");
			}

		}
		this.t = s.tipo;
		return s.tipo;// retorno vem da tabela
	}

	@Override
	public String gerar(Object o) {
		// TODO invokestatic ExemploWhile/print()V
		StringBuilder sb = new StringBuilder();
		for (Expressao e : listaExprs) {
			
			sb.append(e.gerar(null));
			
		}
		sb.append("\ninvokestatic " + GerarCodigo.nome + "/" + nomeFuncao + "(");
		for (Expressao e : listaExprs) {

			sb.append(GerarCodigo.tradutorTipos((Tipo) e.getTipo()));

		}
		sb.append(")" + GerarCodigo.tradutorTipos(t));
		return sb.toString();
	}

	@Override
	public Tipo getTipo() {
		
		return t;
	}

	@Override
	public void setTipo(Tipo t) {
		this.t = t;
		
	}

}
