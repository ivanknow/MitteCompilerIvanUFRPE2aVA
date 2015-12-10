package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class Iteracao implements Comando {
	
	private Expressao expressao;
	private Comando comando;
	public Iteracao(Expressao expressao, Comando comando) {
		super();
		this.expressao = expressao;
		this.comando = comando;
	}
	@Override
	public String toString() {
		return "\n Iteracao [expressao=" + expressao + ", comando=" + comando + "]";
	}
	@Override
	public Object analyse() throws SemanticalException {
		Tipo tipoExp = (Tipo)expressao.analyse();
		if(tipoExp != Tipo.BOOLEAN){
			throw new SemanticalException("Condicao do laço deve ser BOOLEAN");
		}
		;
		return comando.analyse();
	}
	@Override
	public String gerar(Object o) {
		
StringBuilder sb = new StringBuilder();
		
		int labelId = GerarCodigo.getLabelCount();
		
		sb.append("loop" + labelId + ":\n");
		
		sb.append(expressao.gerar(null));
		
		sb.append("bipush 1\n"); 

		sb.append("ifne fim" + labelId + "\n");
		
		sb.append(comando.gerar(null));
		
		sb.append("goto loop" + labelId + ":\n");

		
		sb.append("fim" + labelId + ":\n");
		
		return sb.toString();
	}
	
	
	
	
}
