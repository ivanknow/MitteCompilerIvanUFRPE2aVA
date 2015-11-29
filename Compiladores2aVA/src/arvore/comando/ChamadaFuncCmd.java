package arvore.comando;

import semantica.SemanticalException;

public class ChamadaFuncCmd implements Comando {
	private ChamadaFunc chamada;

	public ChamadaFuncCmd(ChamadaFunc chamada) {
		super();
		this.chamada = chamada;
	}

	@Override
	public Object analyse() throws SemanticalException {
		
		return chamada.analyse();
	}
	
}
