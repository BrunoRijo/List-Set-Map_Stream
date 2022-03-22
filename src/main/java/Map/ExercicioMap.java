package Map;

import java.util.*;

//Streams são formas simplificadas de manipulação de collections.
//Utilizando conceitos de Lambda, Classe anônima, Reference Method
public class ExercicioMap {

/*
Dadas as seguintes informações de id e contato, crie um dicionário e
ordene este dicionários exibindo (Nome, id - Nome contato):

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/
    public static void main(String[] args) {

        System.out.println("-- Ordem aleatória --");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato(2222, "Simba"));
            put(4, new Contato(5555, "Cami"));
            put(3, new Contato(1111, "Jon"));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        };

        System.out.println("-- Ordem de Inserção --");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato(2222, "Simba"));
            put(4, new Contato(5555, "Cami"));
            put(3, new Contato(1111, "Jon"));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        };

        System.out.println("Ordem id");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        };
    }
}

class Contato {
    private int numero;
    private String nome;

    public Contato(int id, String nome) {
        this.numero = id;
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return numero == contato.numero && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nome);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + numero +
                ", nome='" + nome + '\'' +
                '}';
    }
}
