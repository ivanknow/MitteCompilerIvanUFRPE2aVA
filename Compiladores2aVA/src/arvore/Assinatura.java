package arvore;

import java.util.ArrayList;
import java.util.List;

import arvore.expressao.Identificador;
import semantica.SemanticFunctionItem;
import semantica.SemanticItem;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;
import semantica.TabelaEscopo;

public class Assinatura implements SemanticallyAnalyzable {
	Identificador identificador;
	Tipo tipo = Tipo.VOID;
	List<Identificador> parametros;

	public Assinatura(Identificador identificador, List parametros, Tipo tipo) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.parametros = parametros;
	}

	public Assinatura(Identificador identificador, List parametros) {
		super();
		this.identificador = identificador;
		this.parametros = parametros;
	}

	public Assinatura() {

	}

	@Override
	public String toString() {
		return "\nAssinatura [identificador=" + identificador + ", tipo=" + tipo + ", parametros=" + parametros + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		TabelaEscopo tabela = TabelaEscopo.getInstance();

		List<Tipo> tiposParam = new ArrayList<Tipo>();

		for (Identificador i : parametros) {
			tiposParam.add(i.getTipo());
		}

		SemanticFunctionItem s = new SemanticFunctionItem(tipo, tiposParam);

		tabela.addItem(identificador.getLabel(), s);

		// criar novo escopo
		tabela.criaNovoEscopo();

		for (Identificador i : parametros) {

			tabela.addItem(i.getLabel(), new SemanticItem(i.getTipo()));
		}
		return tipo;
	}

}
