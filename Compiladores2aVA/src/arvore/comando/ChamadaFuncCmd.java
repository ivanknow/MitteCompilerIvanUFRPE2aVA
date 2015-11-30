package arvore.comando;

import arvore.Tipo;
import semantica.SemanticalException;

public class ChamadaFuncCmd implements Comando {
	private ChamadaFunc chamada;

	public ChamadaFuncCmd(ChamadaFunc chamada) {
		super();
		this.chamada = chamada;
	}

	@Override
	public Object analyse() throws SemanticalException {
		//TODO o call significa sem retorno?
		return Tipo.VOID;
	}
	
}
