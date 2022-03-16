package Set;

//Classe para estudar a praticar o uso do Set.

import java.util.*;

public class ExemploSet {

    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas.toString());

        //O método contains, permite conferir se um elemento faz parte do conjunto set
        System.out.println("Conferir se a nota 5.0 está no conjunto"+ notas.contains(5d));

        //Métodos de recuperar maior e menor valor
        System.out.println("Exiba a menor nota"+ Collections.min(notas));
        System.out.println("Exiba a menor nota"+ Collections.max(notas));

        /*Para que seja feitas somas nos valores contidos em set, é necessário
        utilizar um iterator*/
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next =  iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: "+ soma);

        //O tamanho do conjunto pode ser pegado através do método size().
        System.out.println("Exiba a média das notas" + soma/notas.size());

        System.out.println("Remova a nota 0:");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba na lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //Para salvar a ordem em que foi informado é necessário criar um LinkedHashSet
        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2 + "Conjuntos Set não guarda objetos que se repetem");

        System.out.println("Exiba todas as notas em ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto");
        notas.clear();

        System.out.println("Conferindo se o conjunto está vazio: "+ notas.isEmpty());
        System.out.println("Conferindo se o conjunto 2 está vazio: "+ notas2.isEmpty());
        System.out.println("Conferindo se o conjunto 3 está vazio: "+ notas3.isEmpty());
    }

}
