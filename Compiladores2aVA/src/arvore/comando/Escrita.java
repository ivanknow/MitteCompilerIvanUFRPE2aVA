package arvore.comando;

import arvore.Tipo;
import arvore.expressao.Expressao;
import gerador.GerarCodigo;
import semantica.SemanticalException;

public class Escrita implements Comando {
	private Expressao expressao;

	public Escrita(Expressao expressao) {
		this.expressao = expressao;
	}

	@Override
	public String toString() {
		return "\n Escrita [expressao=" + expressao + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		expressao.analyse();
		return Tipo.VOID;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
		try {
			Tipo tipoExp = (Tipo) expressao.analyse();
			sb.append("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
			sb.append(expressao.gerar(null));
			sb.append("invokevirtual java/io/PrintStream/println(" + GerarCodigo.tradutorTipos(tipoExp) + ")V");
		} catch (SemanticalException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
