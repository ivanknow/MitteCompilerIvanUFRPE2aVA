package arvore;

import arvore.comando.Bloco;

public class DeclFuncao implements DeclGlobal {
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
	
	
}
