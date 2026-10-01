package ExerciciosLista1;



public class Exercicio5 {

    public static boolean estaBalanceado(String sequencia) {
        if (sequencia == null) {
            return true;
        }

        Pilha pilha = new Pilha(sequencia.length());

        for (int i = 0; i < sequencia.length(); i++) {
            char c = sequencia.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.vazia()) {
                    return false;
                }

                char topo = pilha.pop();

                if (c == ')' && topo != '(') {
                    return false;
                }
                if (c == ']' && topo != '[') {
                    return false;
                }
                if (c == '}' && topo != '{') {
                    return false;
                }
            }
        }

        return pilha.vazia();
    }

    public static void main(String[] args) {
        String exp1 = "{ab}[cde]";
        String exp2 = "{ab[cd]efg}";
        String exp3 = "[abcde{efg]}";
        String exp4 = "abcdef";

        System.out.println(exp1 + " -> " + (estaBalanceado(exp1) ? "Balanceado" : "Não balanceado"));
        System.out.println(exp2 + " -> " + (estaBalanceado(exp2) ? "Balanceado" : "Não balanceado"));
        System.out.println(exp3 + " -> " + (estaBalanceado(exp3) ? "Balanceado" : "Não balanceado"));
        System.out.println(exp4 + " -> " + (estaBalanceado(exp4) ? "Balanceado" : "Não balanceado"));
    }
}
