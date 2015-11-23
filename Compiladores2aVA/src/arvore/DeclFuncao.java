package arvore;

import arvore.comando.Bloco;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;

public class DeclFuncao implements DeclGlobal,SemanticallyAnalyzable {
	private Bloco bloco;
	private Assinatura assinatura;
	public DeclFuncao(Assinatura assinatura,Bloco bloco) {
		super();
		this.bloco = bloco;
		this.assinatura = assinatura;
	}
	
	public DeclFuncao() {
		
	}

	@Override
	public String toString() {
		return "DeclFuncao [bloco=" + bloco + ", assinatura=" + assinatura + "]";
	}

	@Override
	public Object analyse() throws SemanticalException {
		assinatura.analyse();
		bloco.analyse();
		return null;
	}
	
	
}
