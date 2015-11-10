package arvore.comando;

import java.util.ArrayList;
import java.util.List;

public class Bloco implements Comando {
	private List<Comando> comandos;
	
	public Bloco() {
		this.comandos = new ArrayList<>();
	}
	
	public void add(Comando cmd) {
		this.comandos.add(cmd);
	}


}
