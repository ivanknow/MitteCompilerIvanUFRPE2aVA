package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;

	/**
	 * Construtor para if-else completo.
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
	}

	/**
	 * Construtor para if sem else.
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
	}

	@Override
	public Object analyse() throws SemanticalException {
		Tipo retorno = Tipo.VOID;

		Tipo tipoExp = (Tipo) expressao.analyse();
		if (tipoExp != Tipo.BOOLEAN) {
			throw new SemanticalException("Expressao deve ser BOOLEAN");
		}
		retorno = (Tipo) comandoIf.analyse();
		if (comandoElse != null) {

			Tipo tipoElse = (Tipo) comandoElse.analyse();
			if (tipoElse != retorno) {
				throw new SemanticalException("Blocos IF-ELSE devem posuir o mesmo tipo de retorno");
			}

		}

		return retorno;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(expressao.gerar(null));
		
		int labelIdIf = GerarCodigo.getLabelCount();

		sb.append("bipush 1\n"); // adiciona true na pilha

		sb.append("if_icmpne cmd" + labelIdIf + "\n");// se for diferente de true pula para else ou fim
		
		sb.append(comandoIf.gerar(null));// se é true executa bloco if
		
		sb.append("goto fim" + labelIdIf + "\n");// pula pro fim
		
		sb.append("cmd" + labelIdIf + ":\n");// label do else

		if (comandoElse != null) { // se else n for nulo
			sb.append(comandoElse.gerar(null)); //add comandos do else
		}
		sb.append("fim" + labelIdIf + ":\n");// fim
		
		return sb.toString();
	}

}
