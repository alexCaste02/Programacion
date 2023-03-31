package AlejandroCastellanosExamenT11;

import java.util.HashMap;
import java.util.Map;

public class ContadorLetras {

    public static void main(String[] args) {
        String frase="Decir que Java es estupendo porque funciona con todos los sistemas operativos es como decir que el sexo anal es estupendo porque funciona con todos los géneros (Alanna)";

        //Creamos el mapa (en este caso un HashMap)
        //Clave - letra (asi que usamos tipo Character)
        //Valor - repeticiones (int)
        Map<Character,Integer> distribucion = new HashMap<>();


        //recorremos los caracteres del String a traves del array devuelto por
        // el metodo toCharArray()

        // si la clave ya se contiene, sumamos uno al valor (+1 repeticion) de la clave
        // si no, añadimos una entrada con dicha clave y valor=1
        for (char c : frase.toCharArray()) {
            if(distribucion.containsKey(c))
                distribucion.put(c,distribucion.get(c)+1);
            else
                distribucion.put(c,1);
        }

//        System.out.println(distribucion);

        //mostramos las entradas (a traves de recorrer el entrySet del mapa)
        System.out.println("DISTRIBUCION");
        for (Map.Entry<Character, Integer> entry : distribucion.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }



    }

}
