package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
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
		retorno =(Tipo) comandoIf.analyse();
		if (comandoElse != null) {
			
			Tipo tipoElse = (Tipo)comandoElse.analyse();
			if(tipoElse != retorno){
				throw new SemanticalException("Blocos IF-ELSE devem posuir o mesmo tipo de retorno");
			}
			
		}

		return retorno;
	}

}
