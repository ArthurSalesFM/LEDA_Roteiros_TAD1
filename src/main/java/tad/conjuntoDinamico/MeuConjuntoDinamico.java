package tad.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{
    
    private Integer[] meusDados = null;
    private int posInsercao = 0;
    private static final int TAMANHO_INICIAL = 10;
	
    public MeuConjuntoDinamico() {
        meusDados = new Integer[TAMANHO_INICIAL];
    }
        
    @Override
    public void inserir(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Não é permitido inserir um elemento nulo.");
        }

        if (posInsercao == meusDados.length) {
            meusDados = aumentarArray();
        }

        meusDados[posInsercao] = item;
        posInsercao++;
    }
	
    private Integer[] aumentarArray() {
        int novoTamanho = (int) (meusDados.length + (meusDados.length * 0.3) );

        Integer[] novoArray = new Integer[novoTamanho];

        for (int i = 0; i < meusDados.length; i++) {
            novoArray[i] = meusDados[i];
        }

        return novoArray;
    }

    @Override
    public Integer remover(Integer item) {
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i] != null && meusDados[i].equals(item)) {
                Integer elementoRemovido = meusDados[i];
               
                for (int j = i; j < posInsercao - 1; j++) {
                    meusDados[j] = meusDados[j + 1];
                }
                meusDados[posInsercao - 1] = null;
                posInsercao--;
                return elementoRemovido;
            }
        }
        return null;
    }

    @Override
    public Integer predecessor(Integer item) {
        Integer predecessor = null;
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i] != null && meusDados[i].equals(item)) {
                if (i > 0) {
                    predecessor = meusDados[i - 1];
                }
                break;
            }
        }
        return predecessor;
    }

    @Override
    public Integer sucessor(Integer item) {
        Integer sucessor = null;
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i] != null && meusDados[i].equals(item)) {
                if (i < posInsercao - 1) {
                    sucessor = meusDados[i + 1];
                }
                break;
            }
        }
        return sucessor;
    }

    @Override
    public int tamanho() {
        return posInsercao;
    }

    @Override
    public Integer buscar(Integer item) {
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i] != null && meusDados[i].equals(item)) {
                return meusDados[i];
            }
        }
        return null;
    }

    @Override
    public Integer minimum() {
        if (posInsercao == 0) {
            return null;
        }
        Arrays.sort(meusDados, 0, posInsercao);
        return meusDados[0];
    }

    @Override
    public Integer maximum() {
        if (posInsercao == 0) {
            return null;
        }
        Arrays.sort(meusDados, 0, posInsercao);
        return meusDados[posInsercao - 1];
    }        

}
