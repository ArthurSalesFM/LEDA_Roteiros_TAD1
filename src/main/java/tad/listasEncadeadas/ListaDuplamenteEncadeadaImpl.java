package tad.listasEncadeadas;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

    private NodoListaDuplamenteEncadeada<T> cabeca = null;
    private NodoListaDuplamenteEncadeada<T> cauda = null;

    public ListaDuplamenteEncadeadaImpl() {
        cabeca = new NodoListaDuplamenteEncadeada<T>();
        cauda = new NodoListaDuplamenteEncadeada<T>();
        cabeca.setProximo(cauda);
        cauda.setAnterior(cabeca);
    }

    @Override
    public boolean isEmpty() {
        return cabeca.getProximo() == cauda;
    }

    @Override
    public int size() {
        int count = 0;
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (current != cauda) {
            count++;
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        return count;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> search(T chave) {
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (current != cauda) {
            if (current.getChave().equals(chave)) {
                return current;
            }
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        return null;
    }

    @Override
    public void insert(T chave) {
        NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);
        novoNo.setProximo(cabeca.getProximo());
        ((NodoListaDuplamenteEncadeada<T>) cabeca.getProximo()).setAnterior(novoNo);
        novoNo.setAnterior(cabeca);
        cabeca.setProximo(novoNo);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> remove(T chave) {
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (current != cauda) {
            if (current.getChave().equals(chave)) {
                NodoListaDuplamenteEncadeada<T> removedNode = current;
                current.getAnterior().setProximo(current.getProximo());
                ((NodoListaDuplamenteEncadeada<T>) current.getProximo()).setAnterior(current.getAnterior());
                return removedNode;
            }
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        return null;
    }

    @Override
    public String imprimeEmOrdem() {
        StringBuilder valores = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (current != cauda) {
            valores.append(current.getChave()).append(", ");
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        if (valores.length() > 2) {
            valores.setLength(valores.length() - 2);
        }
        return valores.toString();
    }

    @Override
    public String imprimeInverso() {
        StringBuilder valores = new StringBuilder();
        NodoListaDuplamenteEncadeada<T> current = cauda.getAnterior();
        while (current != cabeca) {
            valores.append(current.getChave()).append(", ");
            current = current.getAnterior();
        }
        if (valores.length() > 2) {
            valores.setLength(valores.length() - 2);
        }
        return valores.toString();
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        while (current != cauda && !current.getChave().equals(chave)) {
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        if (current == cauda || current.getProximo() == cauda) {
            return null;
        }
        return (NodoListaDuplamenteEncadeada<T>) current.getProximo();
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
        NodoListaDuplamenteEncadeada<T> current = cabeca;
        while (current.getProximo() != cauda && !current.getProximo().getChave().equals(chave)) {
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        if (current.getProximo() == cauda || current == cabeca) {
            return null;
        }
        return (NodoListaDuplamenteEncadeada<T>) current;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        int size = size();
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        NodoListaDuplamenteEncadeada<T> current = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        for (int i = 0; i < size; i++) {
            array[i] = current.getChave();
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }
        return array;
    }

    @Override
    public void inserePrimeiro(T elemento) {
        NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(elemento);
        novoNo.setProximo(cabeca.getProximo());
        ((NodoListaDuplamenteEncadeada<T>) cabeca.getProximo()).setAnterior(novoNo);
        novoNo.setAnterior(cabeca);
        cabeca.setProximo(novoNo);
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removeUltimo() {
        NodoListaDuplamenteEncadeada<T> ultimo = (NodoListaDuplamenteEncadeada<T>) cauda.getAnterior();
        if (ultimo != cabeca) {
            ultimo.getAnterior().setProximo(cauda);
            cauda.setAnterior(ultimo.getAnterior());
            ultimo.setAnterior(null);
            ultimo.setProximo(null);
            return ultimo;
        }
        return null;
    }

    @Override
    public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
        NodoListaDuplamenteEncadeada<T> primeiro = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        if (primeiro != cauda) {
            cabeca.setProximo(primeiro.getProximo());
            ((NodoListaDuplamenteEncadeada<T>) primeiro.getProximo()).setAnterior(cabeca);
            primeiro.setAnterior(null);
            primeiro.setProximo(null);
            return primeiro;
        }
        return null;
    }

    @Override
    public void insert(T chave, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites.");
        }

        NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);
        NodoListaDuplamenteEncadeada<T> current = cabeca;

        for (int i = 0; i < index; i++) {
            current = (NodoListaDuplamenteEncadeada<T>) current.getProximo();
        }

        novoNo.setAnterior(current);
        novoNo.setProximo(current.getProximo());
        ((NodoListaDuplamenteEncadeada<T>) current.getProximo()).setAnterior(novoNo);
        current.setProximo(novoNo);
    }


}
