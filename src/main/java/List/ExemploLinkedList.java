package List;

/*      Resolva esses exercícios utilizando os métodos da implementação linkedList
1 -> Crie uma lista chamada notas2 e coloque todos os elementos da list ArrayList nessa nova lista
2 -> Mostre a primeira nota da nova lista sem removê-la.
3 -> Mostre a primeira nota da nova lista removendo-a.
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class ExemploLinkedList {

    public static void main(String[] args) {

//        A lista do exercicio anterior
        ArrayList<Double> listNotes = new ArrayList<>();
        listNotes.add(7d);
        listNotes.add(8.5);
        listNotes.add(9.3);
        listNotes.add(5d);
        listNotes.add(7d);
        listNotes.add(0.0);
        listNotes.add(3.6);

/*        O método LinkedList é a versão de lista duplamente encadeada do método List
        ele possui os mesmos métodos de uma List e sua vantagem é o ganho de performance
                em operações como adicionar ou remover elementos.*/
        LinkedList<Double> listNotes2 = new LinkedList<>();

//        Percorrendo a List com foreach e adicionando os elementos na LinkedList
        for (Double number : listNotes) listNotes2.add(number);
        System.out.println(listNotes2);

//        Vou mostrar o primeiro elemento utilizando o getFirst()
        System.out.println("O primeiro elemento da LinkedList é: " + listNotes2.getFirst());

        System.out.println("Vamos remover o primeiro numero da lista agora");
        listNotes2.removeFirst();
        System.out.println("Tcharammm, essa é a nova lista:"+ listNotes2);

    }
}
