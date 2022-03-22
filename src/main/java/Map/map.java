package Map;

import java.util.*;

//Em map os valores não podem ter chaves duplicadas, apenas conteúdos
public class map {

    public static void main(String[] args) {
/*
Dados os modelos dos carros e seus respectivos consumos na estrada faça:
modelo = gol - comsumo = 14,4km/l
modelo = uno - comsumo = 15,6km/l
modelo = mobi - comsumo = 16,1km/l
modelo = hb20 - comsumo = 14,5km/l
modelo = kwid - comsumo = 15,6km/l
*/
        System.out.println("Crie um dicionário que relaciona os modelos e seus consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            //O método de adição diferente do List e do Set, se chama put();
           put("gol", 14.4);
           put("uno", 15.6);
           put("mobi", 16.1);
           put("hb20", 14.5);
           put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol para 15,2km/l");
        //Utiliza-se o mesmo método put() para edição, passando a chave como parametro
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares.toString());

        System.out.println("Confira se o modelo tucson está no dicionário" + carrosPopulares.containsKey("tucson"));
        //Este método retorna true ou false.

        System.out.println("Exiba o consumo do uno: "+ carrosPopulares.get("uno"));
        //Método get recupera dados do map, pela chave informada.

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet(); //retorna um set.
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        //Neste caso podemos utilizar o método values, para recuperar os valores.
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o carro mais econonimo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry: entries){
            if (entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("O modelo mais eficiente é: "+ modeloMaisEficiente);
            }
        }

        System.out.println("Exiba o carro menos econonimo e o seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: "+ modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        };

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator =carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("A soma de todos os consumos é :" + soma);
    }
}
