package tad.pilha;

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {
	
//	private ListaEncadeadaIF<Integer> listaEncadeada = new MinhaListaEncadeada<Integer>();

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		// TODO Auto-generated method stub
//		listaEncadeada.insere(item);
		
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer topo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
