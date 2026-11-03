package ExerciciosLista5;

public class Exercicio1 {
    public static ListaDuplamente intersecao(ListaDuplamente l1, ListaDuplamente l2){
        ListaDuplamente l3 = new ListaDuplamente();

        if(l1 == null || l2 == null || l1.vazia() || l2.vazia()){
            return l3;
        }

        for (ListaDuplamente.Elo p1 = l1.prim; p1 != null; p1 = p1.prox){
            boolean encontrado = false;

            for(ListaDuplamente.Elo p2 = l2.prim; p2 != null; p2 = p2.prox){
                if (p1.dado == p2.dado){
                    encontrado = true;
                    break;
                }
            }

            if(encontrado){
                l3.insere(p1.dado);
            }
        }
        return l3;
    }
}
