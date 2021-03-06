package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		Tipo tipoExp = (Tipo) expressao.analyse();

		if (tipoExp == Tipo.VOID) {
			throw new SemanticalException("Nao � possivel retornar VOID");
		}
		return tipoExp;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		

		try {
			Tipo t = (Tipo) expressao.analyse();
			if (t != Tipo.VOID) {
				sb.append(expressao.gerar(null));
				sb.append(GerarCodigo.tradutorTipos(t,"return"));
			}
			
			sb.append("\n");
		} catch (SemanticalException e) {

			e.printStackTrace();
		}
		return sb.toString();
	}

}
