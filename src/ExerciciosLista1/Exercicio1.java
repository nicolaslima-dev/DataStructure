package ExerciciosLista1;

import java.util.Stack;

public class Exercicio1 {
    public static boolean eFormaXCy(String cadeia) {
        Stack<Character> pilha = new Stack<>();
        int i = 0;
        boolean encontrouC = false;

        // 1. Fase de empilhamento de 'x' (antes do 'C')
        while (i < cadeia.length()) {
            char c = cadeia.charAt(i);

            if (c == 'C') {
                encontrouC = true;
                i++; // Consome o 'C' e passa para a leitura de 'y'
                break;
            }

            // Valida se x contém apenas 'A' ou 'B'
            if (c != 'A' && c != 'B') {
                return false;
            }

            pilha.push(c); // Guarda o caractere
            i++;
        }

        // Se a string não possui a letra 'C', a regra não é satisfeita
        if (!encontrouC) {
            return false;
        }

        // 2. Fase de verificação de 'y' (após o 'C')
        while (i < cadeia.length()) {
            char c = cadeia.charAt(i);

            // Valida se y contém apenas 'A' ou 'B'
            if (c != 'A' && c != 'B') {
                return false;
            }

            // Se a pilha esvaziar antes do fim da string, y é maior que x
            if (pilha.isEmpty()) {
                return false;
            }

            // O caractere lido em y deve bater com o topo desempilhado de x
            if (pilha.pop() != c) {
                return false;
            }

            i++;
        }

        // Se a pilha terminou vazia, x e y possuem exatamente o mesmo tamanho
        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        // Exemplo válido
        String exp1 = "ABABBACABBABA"; // x = ABABBA, y = ABBABA
        System.out.println(exp1 + " -> " + eFormaXCy(exp1)); // true

        // Exemplos inválidos
        String exp2 = "ABACABA";   // y não é o inverso de x
        String exp3 = "ABACABBA";  // y tem tamanho diferente de x
        String exp4 = "ABABBABABA"; // Sem a letra C

        System.out.println(exp2 + " -> " + eFormaXCy(exp2)); // false
        System.out.println(exp3 + " -> " + eFormaXCy(exp3)); // false
        System.out.println(exp4 + " -> " + eFormaXCy(exp4)); // false
    }
}

