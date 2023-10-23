package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	
	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		
	}
	
	private Integer[] aumentarArray() {
		// criar um array maior (arrayMaior)
			// Qual é a taxa de aumento desse array?
		// copiar os dados de meusDados (array cheio)
		// colar os dados para o novo array (arrayMaior)
		return null;
	}

	@Override
	public Integer remover(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		
	}

	@Override
	public Integer predecessor(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer sucessor(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public int tamanho() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer buscar(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer minimum() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer maximum() {
		throw new UnsupportedOperationException("Implementar");
	}

}
