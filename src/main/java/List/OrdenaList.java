package List;

/*Dadas as seguintes informações sobre raças de cães, crie uma lista
ordene esta lista exibindo: (raca, peso, origem)

Cachorro 1 = raca: Dauchshund, peso: 4kg, origem:Alemanha
Cachorro 2 = raca: Pischer, peso: 1kg, origem:Egito
Cachorro 3 = raca: Dauchshund, peso: 5kg, origem:Noruega*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaList {

    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>(){{
            add(new Cachorro("Dauchshund", "Alemanha",4));
            add(new Cachorro("Pischer", "Egito",1));
            add(new Cachorro("Dauchshund", "Noruega",5));
        }};

//        Mostre os itens da lista por ordem de inserção
        System.out.println("ordem de inserção: ");
        System.out.println(cachorros);

//        Mostre os itens em ordem aleatória
        System.out.println("Ordem aleatória: ");
        Collections.shuffle(cachorros);
        System.out.println(cachorros);

//        Mostre na ordem Natural
        System.out.println("Ordem natural: ");
        Collections.sort(cachorros);
        System.out.println(cachorros);

//        Ordem de peso
        System.out.println("Ordem de peso: ");
        cachorros.sort(new ComparatorPeso());
        System.out.println(cachorros);

//        Ordem de Raça
        System.out.println("Ordem de Raça: ");
        cachorros.sort(new ComparatorRaca());
        System.out.println(cachorros);

//        Ordem de Origem
        System.out.println("Ordem de Origem: ");
        cachorros.sort(new ComparatorOrigem());
        System.out.println(cachorros);

        System.out.println("Ordem Raca/Peso/Cor");
        cachorros.sort(new ComparatorRacaPesoOrigem());
        System.out.println(cachorros);
    }
}

class Cachorro implements Comparable<Cachorro>{
    private String raca, origem;
    private int peso;

    public Cachorro(String raca, String origem, int peso) {
        this.raca = raca;
        this.origem = origem;
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "Raça: '" + raca + '\'' +
                ", Origem: '" + origem + '\'' +
                ", Peso: " + peso +
                '}';
    }

    @Override
    public int compareTo(Cachorro cachorro) {
        return this.getRaca().compareToIgnoreCase(cachorro.getRaca());
    }
}

class ComparatorPeso implements Comparator<Cachorro> {
    @Override
    public int compare(Cachorro c1, Cachorro c2) {
        return Integer.compare(c1.getPeso(), c2.getPeso());
    }
}

class ComparatorRaca implements Comparator<Cachorro> {
    @Override
    public int compare(Cachorro c1, Cachorro c2) {
        return c1.getRaca().compareToIgnoreCase(c2.getRaca());
    }
}

class ComparatorOrigem implements  Comparator<Cachorro>{

    @Override
    public int compare(Cachorro o1, Cachorro o2) {
        return o1.getOrigem().compareToIgnoreCase(o2.getOrigem());
    }
}

class ComparatorRacaPesoOrigem implements Comparator<Cachorro>{

    @Override
    public int compare (Cachorro c1, Cachorro c2) {
        int raca = c1.getRaca().compareToIgnoreCase(c2.getRaca());
        if (raca != 0) return raca;

        int origem = c1.getOrigem().compareToIgnoreCase(c2.getOrigem());
        if (origem != 0) return origem;

        return Integer.compare(c1.getPeso(), c2.getPeso());
    }
}