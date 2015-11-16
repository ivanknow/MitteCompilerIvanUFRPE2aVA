package arvore;

import java.util.ArrayList;
import java.util.List;

import arvore.expressao.Identificador;

public class ParametrosFormais {
List<Identificador> parametros;

public ParametrosFormais() {
	super();
	parametros = new ArrayList<Identificador>();
}

public List<Identificador> getParametros() {
	return parametros;
}

public void setParametros(List<Identificador> parametros) {
	this.parametros = parametros;
}




}
