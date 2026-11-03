package ExerciciosLista5;

import java.util.function.DoubleFunction;

public class ListaDuplamente {
    protected Elo prim;

    protected class Elo {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo(){
            ant = null;
            prox = null;
        }

        public Elo(int elem){
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem){
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }

    }

    public ListaDuplamente(){
        prim = null;
    }

    public boolean vazia(){
        return prim == null;
    }

    public void insere(int novo){
        Elo p;
        p = new Elo(novo);

        p.prox = prim;
        p.ant = null;

        if(prim != null) {
            prim.ant = p;
        }

        prim = p;
    }

    private Elo busca(int elem) {
        Elo p = null;

        for(p = prim; ((prim != null) && p.dado != elem); p = p.prox);
        return p;
    }

    public boolean remove(int elem){
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        if (p == prim)
            prim = prim.prox;
        else
            p.ant.prox = p.prox;

        if (p.prox != null) {
            p.prox.ant = p.ant;
        }

        p = null;

        return true;
    }

    public void imprime(){
        Elo p;

        System.out.println("Elementos da lista: ");

        for (p = prim; p != null; p = p.prox){
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    public void imprimeReversa() {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa: ");

        p = prim;

        while (p != null) {
            ult = p;
            p = p.prox;
        }

        for (p = ult; p != null; p = p.ant) {
            System.out.print(p.dado + " ");
        }
        System.out.println();
    }

    public void trocaElos(int indiceElo1, int indiceElo2) {
        // Se os índices forem iguais ou a lista estiver vazia, não há o que trocar
        if (indiceElo1 == indiceElo2 || vazia()) return;

        // Garante que indiceElo1 seja sempre o menor índice
        if (indiceElo1 > indiceElo2) {
            int temp = indiceElo1;
            indiceElo1 = indiceElo2;
            indiceElo2 = temp;
        }

        // Busca os nós correspondentes aos índices
        Elo elo1 = obterEloPorIndice(indiceElo1);
        Elo elo2 = obterEloPorIndice(indiceElo2);

        // Caso algum índice esteja fora dos limites da lista
        if (elo1 == null || elo2 == null) return;

        // 1. Salva as referências originais dos vizinhos de cada elo
        Elo ant1 = elo1.ant;
        Elo prox1 = elo1.prox;
        Elo ant2 = elo2.ant;
        Elo prox2 = elo2.prox;

        // Caso 1: Elos adjacentes (elo1 -> elo2)
        if (prox1 == elo2) {
            // Atualiza os vizinhos externos
            if (ant1 != null) ant1.prox = elo2;
            else prim = elo2; // Se elo1 era a cabeça, elo2 passa a ser a nova cabeça

            if (prox2 != null) prox2.ant = elo1;

            // Atualiza os ponteiros internos entre elo1 e elo2
            elo2.ant = ant1;
            elo2.prox = elo1;

            elo1.ant = elo2;
            elo1.prox = prox2;
        }
        // Caso 2: Elos não adjacentes (há nós entre elo1 e elo2)
        else {
            // Atualiza vizinhos externos de elo1 (agora conectados a elo2)
            if (ant1 != null) ant1.prox = elo2;
            else prim = elo2; // Se elo1 era a cabeça, elo2 passa a ser a nova cabeça

            if (prox1 != null) prox1.ant = elo2;

            // Atualiza vizinhos externos de elo2 (agora conectados a elo1)
            if (ant2 != null) ant2.prox = elo1;
            if (prox2 != null) prox2.ant = elo1;

            // Reconfigura os ponteiros de elo1 e elo2
            elo1.prox = prox2;
            elo1.ant = ant2;

            elo2.prox = prox1;
            elo2.ant = ant1;
        }
    }

    /* Método auxiliar privado para buscar o nó por índice (0-based) */
    private Elo obterEloPorIndice(int indice) {
        Elo atual = prim;
        int pos = 0;
        while (atual != null && pos < indice) {
            atual = atual.prox;
            pos++;
        }
        return atual;
    }

    public boolean verificaIgualdade(ListaDuplamente lista2) {
        // Se a lista recebida for nula, são diferentes
        if (lista2 == null) return false;

        // Se apontarem para a mesma instância na memória, são idênticas
        if (this == lista2) return true;

        // Inicia a comparação recursiva a partir das duas cabeças (prim)
        return verificaIgualdadeRec(this.prim, lista2.prim);
    }

    /* Método auxiliar privado para efetuar a recursão elo a elo */
    private boolean verificaIgualdadeRec(Elo p1, Elo p2) {
        // Caso Base 1: Ambos os ponteiros chegaram ao fim (null) ao mesmo tempo
        // Significa que todos os elementos anteriores foram iguais e as listas têm o mesmo tamanho
        if (p1 == null && p2 == null) {
            return true;
        }

        // Caso Base 2: Uma lista chegou ao fim antes da outra (tamanhos diferentes)
        if (p1 == null || p2 == null) {
            return false;
        }

        // Caso Base 3: O conteúdo do nó atual da lista corrente é diferente da lista2
        if (p1.dado != p2.dado) {
            return false;
        }

        // Passo Recursivo: Avança simultaneamente para os próximos nós (prox)
        return verificaIgualdadeRec(p1.prox, p2.prox);
    }

}
