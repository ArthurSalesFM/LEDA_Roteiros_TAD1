package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {

    private ListaEncadeadaIF<Integer> fila;
    
    public FilaListaEncadeada() {
        fila = new ListaEncadeadaImpl<>();
    }

    @Override
    public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
        fila.insert(item.getChave());
    }

    @Override
    public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        
        NodoListaEncadeada<Integer> cabeca = fila.search(0);
        fila.remove(cabeca.getChave());
        return cabeca;
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCauda() {
        int tamanho = fila.size();
        if (tamanho > 0) {
            return fila.search(tamanho - 1);
        } else {
            return null;
        }
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCabeca() {
        return fila.search(0);
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
