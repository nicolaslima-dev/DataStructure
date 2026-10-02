package ExerciciosLista2;

public class Exercicio3 {
    public static void main(String[] args) {
        FilaDePilhas filaPilhas = new FilaDePilhas(2);
        Pilha p1 = new Pilha(2);
        p1.empilhar(1);
        p1.empilhar(2);
        filaPilhas.enfileirar(p1);
        System.out.println("Fila de Pilhas operando com sucesso.");

        PilhaDeFilas pilhaFilas = new PilhaDeFilas(2);
        Fila f1 = new Fila(2);
        f1.enfileirar(10);
        pilhaFilas.empilhar(f1);
        System.out.println("Pilha de Filas operando com sucesso.");

        FilaDeFilas filaFilas = new FilaDeFilas(2);
        Fila f2 = new Fila(2);
        f2.enfileirar(20);
        filaFilas.enfileirar(f2);
        System.out.println("Fila de Filas operando com sucesso.");
    }
}

class FilaDePilhas {
    Pilha[] elementos;
    int inicio;
    int fim;
    int tamanho;

    public FilaDePilhas(int capacidade) {
        elementos = new Pilha[capacidade];
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

    public void enfileirar(Pilha p) {
        if (!isCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = p;
            tamanho++;
        }
    }

    public Pilha desenfileirar() {
        if (!isVazia()) {
            Pilha p = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return p;
        }
        return null;
    }
}

class PilhaDeFilas {
    Fila[] elementos;
    int topo;

    public PilhaDeFilas(int capacidade) {
        elementos = new Fila[capacidade];
        topo = -1;
    }

    public boolean isVazia() {
        return topo == -1;
    }

    public boolean isCheia() {
        return topo == elementos.length - 1;
    }

    public void empilhar(Fila f) {
        if (!isCheia()) {
            elementos[++topo] = f;
        }
    }

    public Fila desempilhar() {
        if (!isVazia()) {
            return elementos[topo--];
        }
        return null;
    }
}

class FilaDeFilas {
    Fila[] elementos;
    int inicio;
    int fim;
    int tamanho;

    public FilaDeFilas(int capacidade) {
        elementos = new Fila[capacidade];
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

    public void enfileirar(Fila f) {
        if (!isCheia()) {
            fim = (fim + 1) % elementos.length;
            elementos[fim] = f;
            tamanho++;
        }
    }

    public Fila desenfileirar() {
        if (!isVazia()) {
            Fila f = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return f;
        }
        return null;
    }
}
