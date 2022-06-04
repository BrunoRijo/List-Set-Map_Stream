package List;

/*
Dada uma lista com 7 notas de de um aluno [7,8.5,9.3,5,7,0,3.6], faça:
1 -> Crie uma lista e adicione as 7 notas;
2 -> Exiba a posição da nota 5.0
3 -> Confira se 5.0 está na lista
4 -> Adicione na lista a nota 8.0 na posição 4
5 -> Substitua a nota 5.0 pela nota 6.0
6 -> Confira se a nota 5.0 está na lista
7 -> Exiba todas as notas na ordem em que foram informadas
8 -> Exiba a terceira nota adicionada
9 -> Exiba a menor nota
10 -> Exiba a maior nota
11 -> Exiba a soma dos valores
12 -> Exiba a média dos valores
13 -> Remova a nota 0
14 -> Remova as notas maiores que 7 e exiba a lista
15 -> Apague toda a lista
16 -> Confira se a lista está vazia
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ExemploList {
    public static void main(String[] args) {

//      Listas podem ser criadas da seguinte forma
        ArrayList<Double> listNotes = new ArrayList<>();

//      Para adicionar itens na lista, utilizamos o método add().
        listNotes.add(7d);
        listNotes.add(8.5);
        listNotes.add(9.3);
        listNotes.add(5d);
        listNotes.add(7d);
        listNotes.add(0.0);
        listNotes.add(3.6);
        System.out.println(listNotes.toString());

//      O método indexOf, recebe o elemento e retorna o índice onde ele se encontra na list
        System.out.println("A nota 5.0 está na posição: " + listNotes.indexOf(5d));

        listNotes.add(4,8.0);
        System.out.println(listNotes.toString());

/*        O método set, serve para substituir um item na List e recebe dois parametros:
        a posição, e o elemento que vai substituir.*/
        listNotes.set(listNotes.indexOf(5d), 6.0);
        System.out.println(listNotes.toString());

//        O método contains, verifica se um elemento está na List e retorna um boolean
        System.out.println("A nota 5.0 está na lista? R:" + listNotes.contains(5d));

//        Para imprimir os itens da List, podemos usar a função foreach
        for (Double nota : listNotes) System.out.println(nota);

//        O método get recebe um indice, e retorna o elemento presente nesse indice na List.
        System.out.println("A terceira nota adicionada foi:" + listNotes.get(2));

/*        A list não possui uma função nativa para retornar os menores e maiores
        Logo, pode-se usar as funções da classe Collection e passar a list como parametro*/
        System.out.println("Menor nota:" + Collections.min(listNotes));
        System.out.println("Maior nota:" + Collections.max(listNotes));

/*      Lists não possuem nenhum método similar ao sum(), então torna-se necessário
        utilizar o iterator*/
        Iterator<Double> iterator = listNotes.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma: " + soma);
        System.out.println("Média: " + soma/listNotes.size());

//        Se não colocar o 'd' depois do numero, a collection interpretará que 0 é a posição
        listNotes.remove(0d);

        Iterator<Double> iterator1 = listNotes.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(listNotes);

//        Método usado para esvaziar a lista.
        listNotes.clear();

//        O método isEmpty verifica se a lista está vazia e retorna um boolean.
        System.out.println("A lista está vazia? R: " + listNotes.isEmpty());




    }
}
