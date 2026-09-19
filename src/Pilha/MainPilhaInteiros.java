package Pilha;

public class MainPilhaInteiros {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        PilhaInteiros pilhaInteiros = new PilhaInteiros(5);
        int n = 0;
        for (int i = 0; i < numeros.length; i++) {
            n = numeros[i];
            pilhaInteiros.pushInt(n);
        }
        while (!pilhaInteiros.isEmpty()){
            n = pilhaInteiros.popInt();
            System.out.println(n);
        }
    }
}
