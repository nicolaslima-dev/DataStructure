package ExerciciosLista2;

public class Pilha {
    int[] elementos;
    int topo;

    public Pilha(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public boolean isVazia() {
        return topo == -1;
    }

    public boolean isCheia() {
        return topo == elementos.length - 1;
    }

    public void empilhar(int valor) {
        if (!isCheia()) {
            elementos[++topo] = valor;
        }
    }

    public int desempilhar() {
        if (!isVazia()) {
            return elementos[topo--];
        }
        return -1;
    }
}
