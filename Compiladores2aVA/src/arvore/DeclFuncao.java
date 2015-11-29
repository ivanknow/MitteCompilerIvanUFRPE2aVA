package arvore;

import arvore.comando.Bloco;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;
import semantica.TabelaEscopo;

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
		TabelaEscopo t = TabelaEscopo.getInstance();
		
		assinatura.analyse();
		
		bloco.analyse();
		//remove escopo 2 da pilha
		t.removeEscopo();
		return Tipo.VOID;
	}
	
	
}
