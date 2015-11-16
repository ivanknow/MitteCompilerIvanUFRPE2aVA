package arvore;

import arvore.expressao.Identificador;

public class Assinatura {
	Identificador identificador;
	Tipo tipo;
	ParametrosFormais parametros;

	public Assinatura(Identificador identificador, ParametrosFormais parametros, Tipo tipo) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.parametros = parametros;
	}

	public Assinatura(Identificador identificador, ParametrosFormais parametros) {
		super();
		this.identificador = identificador;
		this.parametros = parametros;
	}

	public Assinatura() {

	}

}
