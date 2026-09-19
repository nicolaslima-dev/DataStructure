package Pilha;

public class PilhaInteiros {
    private int n;
    private int vetor[];
    private int topo;

    public PilhaInteiros(){
        n = 10;
        vetor = new int[n];
        topo = -1;
    }
    public PilhaInteiros(int tamanho){
        n = tamanho;
        vetor = new int[n];
        topo = -1;
    }
    public boolean isEmpty() {
        return topo == -1 ? true : false;
    }
    public boolean isFull() {
        return topo == n - 1 ? true : false;
    }
    public boolean pushInt(int elemento) {
        if(!this.isFull()){
            vetor[++topo] = elemento;
            return true;
        } else {
            System.out.println("Pilha cheia: push nao funcionou");
            return false;
        }
    }
    public int popInt(){
        int i = 0;
        if(!this.isEmpty()) {
            i = vetor[topo];
            topo--;
        } else {
            System.out.println("Pilha vazia: pop nao funcionou");
            i = Integer.MIN_VALUE;
        }
        return i;
    }
    public int peekInt(){
        int i = 0;
        if (!this.isEmpty()) {
            i = vetor[topo];
        } else {
            System.out.println("Pilha vazia.");
            i = Integer.MIN_VALUE;
        }
        return i;
    }
}
