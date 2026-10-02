package ExerciciosLista2;

public class Exercicio5 {
    public static void main(String[] args) {
        gerarBinarios(16);
    }

    public static void gerarBinarios(int n) {
        FilaString fila = new FilaString(n + 10);
        fila.enfileirar("1");
        for (int i = 1; i <= n; i++) {
            String s1 = fila.desenfileirar();
            System.out.print(s1 + " ");
            fila.enfileirar(s1 + "0");
            fila.enfileirar(s1 + "1");
        }
        System.out.println();
    }
}

class FilaString {
    String[] elementos;
    int inicio;
    int fim;
    int tamanho;

    public FilaString(int capacidade) {
        elementos = new String[capacidade];
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

    public void enfileirar(String s) {
        if (!isCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = s;
            tamanho++;
        }
    }

    public String desenfileirar() {
        if (!isVazia()) {
            String s = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return s;
        }
        return null;
    }
}
