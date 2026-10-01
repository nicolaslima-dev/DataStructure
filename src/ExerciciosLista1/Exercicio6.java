package ExerciciosLista1;



public class Exercicio6 {

    public static String inverterPalavras(String frase) {
        if (frase == null) {
            return null;
        }

        Pilha pilha = new Pilha(frase.length());
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (c != ' ') {
                pilha.push(c);
            } else {
                while (!pilha.vazia()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(' ');
            }
        }

        while (!pilha.vazia()) {
            resultado.append(pilha.pop());
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        String frase1 = "a maçã está podre";
        System.out.println(frase1 + " -> " + inverterPalavras(frase1));

        String frase2 = "estrutura de dados";
        System.out.println(frase2 + " -> " + inverterPalavras(frase2));
    }
}
