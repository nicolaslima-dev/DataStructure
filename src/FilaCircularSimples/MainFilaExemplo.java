package FilaCircularSimples;

public class MainFilaExemplo {

    public static void main(String[] args) {
        Fila fila = new Fila(5);

        fila.insere(10);
        fila.insere(20);
        fila.insere(30);

        System.out.println("Removido: " + fila.remove());
        System.out.println("Removido: " + fila.remove());

        fila.insere(40);
        fila.insere(50);
        fila.insere(60);
        fila.insere(70);

        System.out.println("\nRemovendo o restante da fila:");
        while (!fila.vazia()) {
            System.out.println("Removido: " + fila.remove());
        }
    }
}