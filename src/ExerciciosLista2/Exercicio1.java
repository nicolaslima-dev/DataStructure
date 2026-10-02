package ExerciciosLista2;

public class Exercicio1 {
    public static void main(String[] args) {
        SistemaOperacional so = new SistemaOperacional(5);
        so.incluirProcesso(new Processo(1, 10));
        so.incluirProcesso(new Processo(2, 20));
        so.incluirProcesso(new Processo(3, 5));
        
        so.imprimirFila();
        
        Processo p = so.retirarProcessoMaiorEspera();
        System.out.println("Processo com maior espera (removido): " + p.id);
    }
}

class SistemaOperacional {
    FilaProcessos fila;

    public SistemaOperacional(int capacidade) {
        fila = new FilaProcessos(capacidade);
    }

    public void incluirProcesso(Processo p) {
        fila.enfileirar(p);
    }

    public Processo retirarProcessoMaiorEspera() {
        return fila.desenfileirar();
    }

    public void imprimirFila() {
        int atual = fila.inicio;
        for (int i = 0; i < fila.tamanho; i++) {
            Processo p = fila.processos[atual];
            System.out.println("Processo ID: " + p.id + " | Tempo de Espera: " + p.tempoEspera);
            atual = (atual + 1) % fila.processos.length;
        }
    }
}

class Processo {
    int id;
    int tempoEspera;

    public Processo(int id, int tempoEspera) {
        this.id = id;
        this.tempoEspera = tempoEspera;
    }
}

class FilaProcessos {
    Processo[] processos;
    int inicio;
    int fim;
    int tamanho;

    public FilaProcessos(int capacidade) {
        processos = new Processo[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    public boolean isCheia() {
        return tamanho == processos.length;
    }

    public void enfileirar(Processo p) {
        if (!isCheia()) {
            fim = (fim + 1) % processos.length;
            processos[fim] = p;
            tamanho++;
        }
    }

    public Processo desenfileirar() {
        if (!isVazia()) {
            Processo p = processos[inicio];
            inicio = (inicio + 1) % processos.length;
            tamanho--;
            return p;
        }
        return null;
    }
}
