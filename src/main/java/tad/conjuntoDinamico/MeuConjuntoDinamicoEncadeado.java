package tad.conjuntoDinamico;

import tad.listasEncadeadas.ListaEncadeadaIF;
import tad.listasEncadeadas.ListaEncadeadaImpl;
import tad.listasEncadeadas.NodoListaEncadeada;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {
    
    private ListaEncadeadaIF<Integer> lista;

    public MeuConjuntoDinamicoEncadeado() {
        lista = new ListaEncadeadaImpl<>();
    }

    @Override
    public void inserir(Integer item) {
        if (buscar(item) == null) {
            lista.insert(item);
        }
    }

    @Override
    public Integer remover(Integer item) {
        NodoListaEncadeada<Integer> nodo = lista.search(item);
        if (nodo != null) {
            lista.remove(item);
            return item;
        }
        return null;
    }

    @Override
    public Integer predecessor(Integer item) {
        NodoListaEncadeada<Integer> nodo = lista.predecessor(item);
        if (nodo != null) {
            return nodo.getChave();
        }
        return null;
    }

    @Override
    public Integer sucessor(Integer item) {
        NodoListaEncadeada<Integer> nodo = lista.sucessor(item);
        if (nodo != null) {
            return nodo.getChave();
        }
        return null;
    }

    @Override
    public int tamanho() {
        return lista.size();
    }

    @Override
    public Integer buscar(Integer item) {
        NodoListaEncadeada<Integer> nodo = lista.search(item);
        if (nodo != null) {
            return nodo.getChave();
        }
        return null;
    }

    @Override
    public Integer minimum() {
        NodoListaEncadeada<Integer> minNodo = lista.search(0);
        if (minNodo != null) {
            return minNodo.getChave();
        }
        return null;
    }

    @Override
    public Integer maximum() {
        NodoListaEncadeada<Integer> maxNodo = lista.search(lista.size() - 1);
        if (maxNodo != null) {
            return maxNodo.getChave();
        }
        return null;
    }
}
