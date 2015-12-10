package arvore;

import java.util.List;

import arvore.comando.Comando;
import arvore.expressao.Expressao;
import arvore.expressao.Identificador;
import gerador.GerarCodigo;
import semantica.SemanticalException;
import semantica.TabelaEscopo;

public class Atribuicao implements Comando {
	private List<Identificador> listaIdents;
	private Expressao expressao;

	public Atribuicao(List<Identificador> listaIdents, Expressao expressao) {
		super();
		this.listaIdents = listaIdents;
		this.expressao = expressao;
	}

	@Override
	public String toString() {
		return "\nAtribuicao [listaIdents=" + listaIdents + ", expressao=" + expressao + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {

		Tipo t = (Tipo) expressao.analyse();
		for (Identificador identificador : listaIdents) {
			if (identificador.analyse() != t) {
				throw new SemanticalException(
						"Tipo atribuido eh diferente do tipo do identificador '" + identificador.getLabel() + "'");
			}
		}
		TabelaEscopo tabela = TabelaEscopo.getInstance();
		return Tipo.VOID;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		for (Identificador identificador : listaIdents) {
			//sb.append(identificador.gerar(null)+"\n");
			sb.append(expressao.gerar(null)+"\n");
			sb.append(GerarCodigo.tradutorTipos(identificador.getTipo(), "store_"+(identificador.getIdEscopo()))+"\n\n");
		}
		return sb.toString();
	}

}
