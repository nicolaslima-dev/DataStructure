package ExerciciosLista2;

public class Fila {
    int[] elementos;
    int inicio;
    int fim;
    int tamanho;

    public Fila(int capacidade) {
        elementos = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    public boolean isCheia() {
        return tamanho == elementos.length;
    }

    public void enfileirar(int valor) {
        if (!isCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = valor;
            tamanho++;
        }
    }

    public int desenfileirar() {
        if (!isVazia()) {
            int valor = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return valor;
        }
        return -1;
    }
}
