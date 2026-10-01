package ExerciciosLista1;



public class Exercicio7 {

    public static double avaliarExpressao(String expressao) {
        PilhaGenerica<Double> operandos = new PilhaGenerica<>(expressao.length());
        Pilha operadores = new Pilha(expressao.length());

        int i = 0;
        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            if (Character.isWhitespace(c) || c == '(') {
                i++;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operadores.push(c);
                i++;
            } else if (c == ')') {
                char op = operadores.pop();
                double v2 = operandos.pop();
                double v1 = operandos.pop();
                double res = 0;

                if (op == '+') {
                    res = v1 + v2;
                } else if (op == '-') {
                    res = v1 - v2;
                } else if (op == '*') {
                    res = v1 * v2;
                } else if (op == '/') {
                    res = v1 / v2;
                }

                operandos.push(res);
                i++;
            } else if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expressao.length() && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
                    sb.append(expressao.charAt(i));
                    i++;
                }
                operandos.push(Double.parseDouble(sb.toString()));
            } else {
                i++;
            }
        }

        return operandos.pop();
    }

    public static void main(String[] args) {
        String exp1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println(exp1 + " = " + avaliarExpressao(exp1));

        String exp2 = "( ( 10 - 2 ) / ( 2 * 2 ) )";
        System.out.println(exp2 + " = " + avaliarExpressao(exp2));
    }
}
