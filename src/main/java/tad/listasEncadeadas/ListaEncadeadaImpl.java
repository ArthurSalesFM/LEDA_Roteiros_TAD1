package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T> {
    
    private NodoListaEncadeada<T> cabeca = null;
    private NodoListaEncadeada<T> cauda = null;
    
    public ListaEncadeadaImpl() {
        cabeca = new NodoListaEncadeada<T>();
        cauda = new NodoListaEncadeada<T>();
        cabeca.setProximo(cauda);
    }

    @Override
    public boolean isEmpty() {
        return cabeca.getProximo() == cauda;
    }

    @Override
    public int size() {
        int count = 0;
        NodoListaEncadeada<T> current = cabeca.getProximo();
        while (current != cauda) {
            count++;
            current = current.getProximo();
        }
        return count;
    }

    @Override
    public NodoListaEncadeada<T> search(T chave) {
        NodoListaEncadeada<T> current = cabeca.getProximo();
        while (current != cauda) {
            if (current.getChave().equals(chave)) {
                return current;
            }
            current = current.getProximo();
        }
        return null;
    }

    @Override
    public void insert(T chave) {
        NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
        novoNo.setProximo(cabeca.getProximo());
        cabeca.setProximo(novoNo);
    }

    @Override
    public NodoListaEncadeada<T> remove(T chave) {
        NodoListaEncadeada<T> current = cabeca;
        while (current.getProximo() != cauda) {
            if (current.getProximo().getChave().equals(chave)) {
                NodoListaEncadeada<T> removedNode = current.getProximo();
                current.setProximo(removedNode.getProximo());
                return removedNode;
            }
            current = current.getProximo();
        }
        return null;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        int size = size();
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        NodoListaEncadeada<T> current = cabeca.getProximo();
        for (int i = 0; i < size; i++) {
            array[i] = current.getChave();
            current = current.getProximo();
        }
        return array;
    }

    @Override
    public String imprimeEmOrdem() {
        StringBuilder valores = new StringBuilder();
        NodoListaEncadeada<T> current = cabeca.getProximo();
        while (current != cauda) {
            valores.append(current.getChave()).append(", ");
            current = current.getProximo();
        }
        if (valores.length() > 2) {
            valores.setLength(valores.length() - 2);
        }
        return valores.toString();
    }

    @Override
    public String imprimeInverso() {
        StringBuilder valores = new StringBuilder();
        NodoListaEncadeada<T> current = cauda.getProximo();
        while (current != cabeca) {
            valores.append(current.getChave()).append(", ");
            current = current.getProximo();
        }
        if (valores.length() > 2) {
            valores.setLength(valores.length() - 2);
        }
        return valores.toString();
    }

    @Override
    public NodoListaEncadeada<T> sucessor(T chave) {
        NodoListaEncadeada<T> current = cabeca.getProximo();
        while (current != cauda && !current.getChave().equals(chave)) {
            current = current.getProximo();
        }
        if (current == cauda || current.getProximo() == cauda) {
            return null;
        }
        return current.getProximo();
    }

    @Override
    public NodoListaEncadeada<T> predecessor(T chave) {
        NodoListaEncadeada<T> current = cabeca;
        while (current.getProximo() != cauda && !current.getProximo().getChave().equals(chave)) {
            current = current.getProximo();
        }
        if (current.getProximo() == cauda || current == cabeca) {
            return null;
        }
        return current;
    }

    @Override
    public void insert(T chave, int index) {
        NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
        novoNo.setProximo(cabeca.getProximo());
        cabeca.setProximo(novoNo);
    }

}
