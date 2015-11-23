package arvore;

import java.util.List;

import arvore.expressao.Identificador;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;

public class Assinatura implements SemanticallyAnalyzable{
	Identificador identificador;
	Tipo tipo;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
