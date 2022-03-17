package Set;

import java.util.*;
/*
Dadas as seguintes informações sobre minhas animações favoritas
crie um conjunto e ordene este conjunto exibindo:
nome, genero, tempo do episódio
Série 1: The Midnight Gospel, Ficção científica, 8
Série 2: Akame Ga Kill, Shounen, 24
Série 3: Boku no Hero, Ação, 96
*/



public class OrdenaSet {

    public static void main(String[] args) {
        System.out.println("--\tEm Ordem aleatória\t");
        Set<Animacao> minhasAnimacoes = new LinkedHashSet<>(){{
           add(new Animacao("The Midnight Gospel", "Ficção científica", 8));
           add(new Animacao("Akame Ga Kill", "Shounen", 24));
           add(new Animacao("Boku no Hero", "Ação", 24));
        }};

        //Utilizando o fot para mostrar os itens do conjunto
        for (Animacao an: minhasAnimacoes) System.out.println(an.getNome()
        + " - " + an.getGenero() + " - " + an.getTempoEpisodio());

        System.out.println("-- Ordem natural (TempoEpisodio) --");
        Set<Animacao> minhasAnimacoes2 = new TreeSet<>(minhasAnimacoes);
        for (Animacao an2: minhasAnimacoes2) System.out.println(an2.getNome()
                + " - " + an2.getGenero() + " - " + an2.getTempoEpisodio());
    }
}

class Animacao implements Comparable<Animacao> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Animacao(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animacao animacao = (Animacao) o;
        return Objects.equals(nome, animacao.nome) && Objects.equals(genero, animacao.genero) && Objects.equals(tempoEpisodio, animacao.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Animacao o) {
        int tempoEp = Integer.compare(this.getTempoEpisodio(), o.getTempoEpisodio());
        if(tempoEp !=0) return tempoEp;
        // Pois caso os tempos comparados sejam iguais, o genero sera usado como desempate.
        return this.getGenero().compareTo(o.getGenero());
    }
}
