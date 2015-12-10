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

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		String s = chamada.gerar(null);
		sb.append(s);
		if(!s.contains("return\n}"))
		sb.append("\npop\n");//remover elemento indesejado da pilha
		return sb.toString();
	}
	
}
