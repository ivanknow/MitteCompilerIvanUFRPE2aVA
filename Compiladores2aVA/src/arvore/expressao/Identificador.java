package arvore.expressao;

public class Identificador implements Expressao {
	private String label, escopo, retorno, tipo;

	public Identificador(String label) {
		
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
