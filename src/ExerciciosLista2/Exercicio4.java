package ExerciciosLista2;

public class Exercicio4 {
    public static void main(String[] args) {
        Fila fila = new Fila(3);
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);

        FilaCircularDupla dupla = converterParaDupla(fila);
        System.out.println("Removido do fim da dupla: " + dupla.removerFim());
        System.out.println("Removido do inicio da dupla: " + dupla.removerInicio());
    }

    public static FilaCircularDupla converterParaDupla(Fila circular) {
        FilaCircularDupla dupla = new FilaCircularDupla(circular.elementos.length);
        while (!circular.isVazia()) {
            dupla.inserirFim(circular.desenfileirar());
        }
        return dupla;
    }
}

class FilaCircularDupla {
    int[] elementos;
    int inicio;
    int fim;
    int tamanho;

    public FilaCircularDupla(int capacidade) {
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

    public void inserirInicio(int valor) {
        if (!isCheia()) {
            if (inicio == 0) {
                inicio = elementos.length - 1;
            } else {
                inicio--;
            }
            if (tamanho == 0) {
                fim = inicio;
            }
            elementos[inicio] = valor;
            tamanho++;
        }
    }

    public void inserirFim(int valor) {
        if (!isCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = valor;
            if (tamanho == 0) {
                inicio = fim;
            }
            tamanho++;
        }
    }

    public int removerInicio() {
        if (!isVazia()) {
            int valor = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            if (tamanho == 0) {
                inicio = 0;
                fim = -1;
            }
            return valor;
        }
        return -1;
    }

    public int removerFim() {
        if (!isVazia()) {
            int valor = elementos[fim];
            if (fim == 0) {
                fim = elementos.length - 1;
            } else {
                fim--;
            }
            tamanho--;
            if (tamanho == 0) {
                inicio = 0;
                fim = -1;
            }
            return valor;
        }
        return -1;
    }
}
