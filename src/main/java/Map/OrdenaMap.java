package Map;

import java.util.*;

public class OrdenaMap {

    public static void main(String[] args) {

        System.out.println("Ordem aleatória");
        //hashMap cria uma estrutura sem se importar com a ordem de inserção
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma breve história do Tempo", 256));
           put("Duhigg, Charles", new Livro("O poder do hábito", 408));
           put("De Queiroz, Raquel", new Livro("A moreninha", 432));
        }};
        for(Map.Entry<String, Livro> livro: meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("Ordem de Inserção" );
        /*Para criar uma estrutura que respeita a ordem de inserção é necessário
        utilizar o linkedHashMap*/
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do Tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("De Queiroz, Raquel", new Livro("A moreninha", 432));
        }};
        for(Map.Entry<String, Livro> livro: meusLivros1.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println(" -- Ordem alfabética de autores -- ");
        //Para ordenar pelas chaves, utuliza-se o treeMap
        Map<String, Livro> meusLivros2 = new TreeMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do Tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("De Queiroz, Raquel", new Livro("A moreninha", 432));
        }};
        for(Map.Entry<String, Livro> livro: meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println(" -- Ordem alfabética dos livros");
        // Livros estão no valor do map, então precisamos ir pelo values()
        Set<Map.Entry<String, Livro>> meusLivros3= new TreeSet<>(new Map.Livro.ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        System.out.println(meusLivros3);
        for(Map.Entry<String, Livro> livro: meusLivros3){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }
    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    static class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
        @Override
        public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
            return l1.getValue().getNome().compareTo(l2.getValue().getNome());
        }
    }
}
