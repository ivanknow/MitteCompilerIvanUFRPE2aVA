package arvore.expressao;

import arvore.Tipo;
import gerador.GerarCodigo;
import semantica.SemanticalException;
import semantica.TabelaEscopo;

public class Identificador implements Expressao {
	private String label, escopo, retorno;
	Tipo tipo;
	private int idEscopo;

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
	

	public int getIdEscopo() {
		return idEscopo;
	}

	public void setIdEscopo(int idEscopo) {
		this.idEscopo = idEscopo;
	}

	@Override
	public String toString() {
		return "\nIdentificador [label=" + label + ", escopo=" + escopo
				+ ", retorno=" + retorno + ", tipo=" + tipo + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		
		if(tipo==null){//caso seja uma utilizacao
			TabelaEscopo tabela = TabelaEscopo.getInstance();
			tipo = tabela.getType(label).tipo;
			idEscopo = tabela.getIdItem(label);
		}
			return this.tipo;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		sb.append(GerarCodigo.tradutorTipos(tipo, "load_"+(idEscopo))+"\n");
		return sb.toString();
	}

	
	
	
	
}
