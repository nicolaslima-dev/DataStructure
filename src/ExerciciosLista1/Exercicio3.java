package ExerciciosLista1;

public class Exercicio3 {

    public static void main(String[] args) {
        DuasPilhas pilhas = new DuasPilhas(10);
        pilhas.push1(10);
        pilhas.push1(20);
        pilhas.push1(30);

        pilhas.push2(100);
        pilhas.push2(200);

        System.out.println("Retirando da Pilha 1: " + pilhas.pop1());
        System.out.println("Retirando da Pilha 2: " + pilhas.pop2());
    }

    static class DuasPilhas {

        private int[] vetor;
        private int topo1;
        private int topo2;

        public DuasPilhas(int tamanho) {
            vetor = new int[tamanho];

            topo1 = -1;
            topo2 = tamanho;
        }

        public void push1(int valor) {

            if (topo1 + 1 == topo2) {
                System.out.println("Overflow: vetor cheio!");
                return;
            }

            topo1++;
            vetor[topo1] = valor;
        }

        public void push2(int valor) {

            if (topo1 + 1 == topo2) {
                System.out.println("Overflow: vetor cheio!");
                return;
            }

            topo2--;
            vetor[topo2] = valor;
        }

        public int pop1() {

            if (topo1 == -1) {
                System.out.println("Pilha 1 vazia!");
                return -1;
            }

            int valor = vetor[topo1];
            topo1--;

            return valor;
        }

        public int pop2() {

            if (topo2 == vetor.length) {
                System.out.println("Pilha 2 vazia!");
                return -1;
            }

            int valor = vetor[topo2];
            topo2++;

            return valor;
        }
    }
}
