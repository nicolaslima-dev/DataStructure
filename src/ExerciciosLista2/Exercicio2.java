package ExerciciosLista2;

public class Exercicio2 {
    public static void main(String[] args) {
        Fila f1 = new Fila(3);
        f1.enfileirar(1);
        f1.enfileirar(2);
        f1.enfileirar(3);

        Fila f2 = new Fila(3);
        f2.enfileirar(4);
        f2.enfileirar(5);
        f2.enfileirar(6);

        Fila filaMista = new Fila(6);
        combinaFilas(filaMista, f1, f2);

        while (!filaMista.isVazia()) {
            System.out.print(filaMista.desenfileirar() + " ");
        }
        System.out.println();
    }

    public static void combinaFilas(Fila atual, Fila f1, Fila f2) {
        while (!f1.isVazia() || !f2.isVazia()) {
            if (!atual.isCheia() && !f1.isVazia()) {
                atual.enfileirar(f1.desenfileirar());
            }
            if (!atual.isCheia() && !f2.isVazia()) {
                atual.enfileirar(f2.desenfileirar());
            }
            if (atual.isCheia()) {
                break;
            }
        }
    }
}
