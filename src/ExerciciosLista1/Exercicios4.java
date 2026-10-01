package ExerciciosLista1;

public class Exercicios4 {

    public static <T> void removerElemento(PilhaGenerica<T> pilha, T elementoAlvo) {
        PilhaGenerica<T> auxiliar = new PilhaGenerica<>(100);
        boolean encontrado = false;

        while (!pilha.vazia() && !encontrado) {
            T temp = pilha.pop();

            if (temp.equals(elementoAlvo)) {
                encontrado = true;
            } else {
                auxiliar.push(temp);
            }
        }

        while (!auxiliar.vazia()) {
            pilha.push(auxiliar.pop());
        }
    }

    public static void main(String[] args) {
        PilhaGenerica<String> pilha = new PilhaGenerica<>(10);

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        pilha.push("D");

        System.out.println("Removendo o elemento 'B'");
        removerElemento(pilha, "B");

        System.out.println("Elementos restantes :");
        while (!pilha.vazia()) {
            System.out.println(pilha.pop());
        }
    }
}