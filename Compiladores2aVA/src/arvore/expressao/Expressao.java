package arvore.expressao;

import arvore.Tipo;
import gerador.Geravel;
import semantica.SemanticallyAnalyzable;

public interface Expressao extends SemanticallyAnalyzable,Geravel{
public Tipo getTipo();
public void setTipo(Tipo t);
}
