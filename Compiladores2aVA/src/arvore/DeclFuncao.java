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
		
		Tipo tipoFunc = (Tipo)assinatura.analyse();
		
		Tipo tipoRetorno =(Tipo)  bloco.analyse();
		
		if(tipoFunc != tipoRetorno){
			throw new SemanticalException("O retorno da função possui um tipo diferente do tipo de declaracao");
		}
		//remove escopo 2 da pilha
		t.removeEscopo();
		return tipoRetorno;
	}
	
	
}
