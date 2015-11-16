package arvore.expressao;

import arvore.Tipo;

public class Identificador implements Expressao {
	private String label, escopo, retorno;
	Tipo tipo;

	public Identificador(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String lexema) {
		this.label = lexema;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	
	
	
}
