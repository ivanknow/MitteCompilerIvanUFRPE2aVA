package arvore;

import arvore.comando.Bloco;

public class DeclFuncao implements DeclGlobal {
	private Bloco bloco;
	private Assinatura assinatura;
	public DeclFuncao(Bloco bloco, Assinatura assinatura) {
		super();
		this.bloco = bloco;
		this.assinatura = assinatura;
	}
	
	public DeclFuncao() {
		
	}
	
	
}
