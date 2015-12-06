package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import semantica.SemanticalException;
import test.GerarCodigo;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Object analyse() throws SemanticalException {
		Tipo tipoExp = (Tipo) expressao.analyse();

		if (tipoExp == Tipo.VOID) {
			throw new SemanticalException("Nao é possivel retornar VOID");
		}
		return tipoExp;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		

		try {
			Tipo t = (Tipo) expressao.analyse();
			if (t != Tipo.VOID) {
				sb.append(GerarCodigo.tradutorTipos(t,"return"));
			}
			sb.append("\n");
		} catch (SemanticalException e) {

			e.printStackTrace();
		}
		return sb.toString();
	}

}
