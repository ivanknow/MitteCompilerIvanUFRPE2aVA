package arvore.comando;

import java.util.ArrayList;
import java.util.List;

import arvore.Tipo;
import semantica.SemanticalException;

public class Bloco implements Comando {
	private List<Comando> comandos;
	
	public Bloco() {
		this.comandos = new ArrayList<Comando>();
	}
	
	public void add(Comando cmd) {
		this.comandos.add(cmd);
	}

	public List<Comando> getComandos() {
		return comandos;
	}
	
	public void setComandos(List<Comando> comandos) {
		this.comandos = comandos;
	}

	@Override
	public String toString() {
		return "\nBloco [comandos=" + comandos + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		for(Comando c:comandos){
			c.analyse();
		}
		return Tipo.VOID;
	}
	
	

}
