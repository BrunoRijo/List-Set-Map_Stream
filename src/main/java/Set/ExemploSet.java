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

    }

}
