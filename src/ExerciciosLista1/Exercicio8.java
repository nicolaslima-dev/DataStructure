package ExerciciosLista1;

import java.util.LinkedHashSet;
import java.util.Set;


public class Exercicio8 {

    public static Set<String> encontrarParesUnicos(int[] array) {
        Set<String> pares = new LinkedHashSet<>();
        if (array == null || array.length < 2) {
            return pares;
        }

        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(array.length);

        for (int i = 0; i < array.length; i++) {
            int atual = array[i];

            while (!pilha.vazia()) {
                int topo = pilha.pop();
                if (topo < atual) {
                    pares.add("(" + atual + "," + topo + ")");
                } else {
                    pilha.push(topo);
                    break;
                }
            }

            if (!pilha.vazia()) {
                int topo = pilha.pop();
                if (topo > atual) {
                    pares.add("(" + topo + "," + atual + ")");
                }
                pilha.push(topo);
            }

            pilha.push(atual);
        }

        return pares;
    }

    public static int contarParesUnicos(int[] array) {
        return encontrarParesUnicos(array).size();
    }

    public static void main(String[] args) {
        int[] sequencia = {1, 2, 3, 4, 5};
        Set<String> pares = encontrarParesUnicos(sequencia);

        System.out.println("Sequência: [1, 2, 3, 4, 5]");
        System.out.println("Pares únicos: " + pares);
        System.out.println("Quantidade de pares únicos: " + pares.size());

        int[] sequencia2 = {1, 5, 2, 4, 3};
        Set<String> pares2 = encontrarParesUnicos(sequencia2);

        System.out.println("\nSequência: [1, 5, 2, 4, 3]");
        System.out.println("Pares únicos: " + pares2);
        System.out.println("Quantidade de pares únicos: " + pares2.size());
    }
}
