package semantica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arvore.Tipo;

public class TabelaEscopo {
	private static TabelaEscopo instance;

	private ArrayList<Map<String, SemanticItem>> pilhaEscopo;

	static {

	}

	private TabelaEscopo() {
	}

	public void addItem(String label, SemanticItem item) throws SemanticalException {
		Map<String, SemanticItem> escopo = getEscopoAtual();
		if (escopo.containsKey(label)) {
			throw new SemanticalException("Variavel '" + label + "' ja foi declarada nesse escopo");
		} else {
			escopo.put(label, item);
		}
		System.out.println(this);
	}

	private Map<String, SemanticItem> getEscopoAtual() {
		return pilhaEscopo.get(pilhaEscopo.size() - 1);
	}
	
	public int getTamanhoEscopoAtual() {
		return getEscopoAtual().size();
	}

	public static TabelaEscopo getInstance() {

		if (instance == null) {
			inicializaInstancia();

		}
		return instance;

	}

	public SemanticItem getType(String label) throws SemanticalException {
		// verifica a tabela de cima e depois a de baixo
		if (getEscopoAtual().containsKey(label)) {
			return getEscopoAtual().get(label);
		} else {
			if (pilhaEscopo.size() > 1) {
				if (pilhaEscopo.get(0).containsKey(label)) {
					return pilhaEscopo.get(0).get(label);
				}
			}

		}
		throw new SemanticalException("Variavel '" + label + "' não foi declarada ainda");

	}

	public void criaNovoEscopo() {
		if (pilhaEscopo.size() > 1) {
			pilhaEscopo.remove(1);
		}
		pilhaEscopo.add(new HashMap<String, SemanticItem>());
		System.out.println(this);
	}

	public void removeEscopo() {
		if (pilhaEscopo.size() > 1)
			instance.pilhaEscopo.remove(1);
		System.out.println(this);
	}

	private static synchronized void inicializaInstancia() {
		if (instance == null) {
			instance = new TabelaEscopo();
			instance.pilhaEscopo = new ArrayList<>();
			instance.pilhaEscopo.add(new HashMap<String, SemanticItem>());
		}
	}

	@Override
	public String toString() {
		return "TabelaEscopo [pilhaEscopo=" + pilhaEscopo + "]";
	}
	

}
