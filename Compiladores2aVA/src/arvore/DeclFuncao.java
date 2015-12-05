package arvore;

import arvore.comando.Bloco;
import arvore.expressao.Identificador;
import semantica.SemanticalException;
import semantica.SemanticallyAnalyzable;
import semantica.TabelaEscopo;
import test.GerarCodigo;

public class DeclFuncao implements DeclGlobal,SemanticallyAnalyzable {
	private int countVariaveisEscopo = 0;
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
		countVariaveisEscopo = t.getTamanhoEscopoAtual();
		return tipoRetorno;
	}

	@Override
	public String gerar(Object o) {
		StringBuilder sb = new StringBuilder();
	 /*.method public static main([Ljava/lang/String;)V
       .limit locals 4
       .limit stack 5*/
		assinatura.identificador.getLabel();
		
		//Assinatura
		sb.append("method public static "
				+ assinatura.identificador.getLabel());
				if(assinatura.identificador.getLabel().equals("main")){
					sb.append("([Ljava/lang/String;)V \n");
				}else{
					sb.append("(");
					String [] param = new String[assinatura.parametros.size()];
					for (int i=0;i<assinatura.parametros.size();i++) {
						param[i] = GerarCodigo.tradutorTipos(assinatura.parametros.get(i).getTipo());
						
					}
					sb.append(String.join(",",param));
					sb.append(")");
					sb.append(GerarCodigo.tradutorTipos(assinatura.tipo));
					sb.append("\n");
				}
				
				sb.append(".limit locals "+countVariaveisEscopo );
				sb.append(".limit stack "+countVariaveisEscopo );
			//Assinatura
			//bloco
			//bloco
			
		
		return sb.toString();
	}
	
	
}
