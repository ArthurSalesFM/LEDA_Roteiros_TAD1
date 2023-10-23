package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
//	NodoListaEncadeada<T> cabeca = null;
	
	NodoListaEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaEncadeada<T> cauda = null;// Estratégia usando marcação sentinela
	
	public ListaEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
	}
	

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Precisa implementar!");
		
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave) {
//		throw new UnsupportedOperationException("Precisa implementar!");
		
		//1. Craiar o novo registro
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		
		//2. Inserir o novo nó na lista
		
		// se a lista estiver vazia**
		if (cabeca.getProximo().equals(cauda)) {
			cabeca = novoNo;
		} else { // lista não está vazia
			novoNo.setProximo(cabeca.getProximo());
			cabeca.setProximo(novoNo);
		}
		
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
		
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// Criar um array usando a classe utilitária conversor
//		Conversor<T> c = new Conversor<T>();
//		T[] meuArray = c.gerarArray(clazz, 10);
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public String imprimeEmOrdem() {
//		throw new UnsupportedOperationException("Precisa implementar!");
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";
		}
		
		return valores.substring(0, valores.length()-2);
		
	}

	@Override
	public String imprimeInverso() {
//		throw new UnsupportedOperationException("Precisa implementar!");
		
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		NodoListaEncadeada<T> anterior = cabeca;
		
		while (!corrente.equals(cauda)) {
			valores += corrente.getChave() + ", ";
		}
		
		
		return valores.substring(0, valores.length()-2);
		
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

}
