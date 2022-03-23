package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExercicioStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1","0","4","1","2","3","9","9","6","5");


        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream().forEach(System.out::println);


        System.out.println("Pegue os 5 ultimos primeiros e coloque dentro de um set");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Tranforme essa lista de String em uma lista de numeros inteiros: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i-> i%2 ==0 && i>2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

       System.out.println("Mostre a média dos numeros: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares: ");
        List<Integer> numerosImpares = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        numerosImpares.removeIf(integer -> integer % 2 != 0);
        numerosImpares.forEach(System.out::println);

    }
}
