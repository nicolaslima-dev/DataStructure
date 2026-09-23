package ExerciciosLista1;

import java.util.Stack;

public class Exercicio2 {

        public static boolean eFormaCadeiasD(String cadeia) {
            if (cadeia == null || cadeia.isEmpty()) {
                return false;
            }

            Stack<Character> pilha = new Stack<>();
            boolean lendoY = false;
            boolean encontrouCNoSegmento = false;

            for (int i = 0; i < cadeia.length(); i++) {
                char c = cadeia.charAt(i);

                // 1. Encontrou o separador de blocos 'D'
                if (c == 'D') {
                    // O bloco xCy anterior precisa ter sido totalmente válido
                    // precisa ter passado por 'C' e a pilha deve estar vazia
                    if (!encontrouCNoSegmento || !pilha.isEmpty()) {
                        return false;
                    }
                    // Prepara as variáveis para o próximo bloco xCy
                    lendoY = false;
                    encontrouCNoSegmento = false;
                    continue;
                }

                // 2. Leitura da parte 'x' (antes do 'C')
                if (!lendoY) {
                    if (c == 'C') {
                        lendoY = true;
                        encontrouCNoSegmento = true;
                    } else if (c == 'A' || c == 'B') {
                        pilha.push(c); // Empilha os caracteres de x
                    } else {
                        return false; // Caractere inválido
                    }
                }
                // 3. Leitura da parte 'y' (depois do 'C')
                else {
                    if (c != 'A' && c != 'B') {
                        return false; // Caractere inválido
                    }
                    if (pilha.isEmpty()) {
                        return false; // y tem mais elementos que x
                    }
                    if (pilha.pop() != c) {
                        return false; // y não é o inverso de x
                    }
                }
            }

            // 4. Verificação final do último bloco
            return encontrouCNoSegmento && pilha.isEmpty();
        }

        public static void main(String[] args) {
            // Exemplo válido com 2 blocos xCy
            String exp1 = "ABACABA D ABABBACABBABA";
            System.out.println(exp1 + " -> " + eFormaCadeiasD(exp1)); // true

            // Inválido: o segundo bloco não é um xCy correto
            String exp2 = "ABACABA D ABACABBA";
            System.out.println(exp2 + " -> " + eFormaCadeiasD(exp2)); // false
        }
}
