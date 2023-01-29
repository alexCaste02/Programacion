/*
Ejercicio 5 – Distribución
Realizar un programa que cree un ArrayList con 10.000 números aleatorios entre 1 y 6
(como si fuese lanzar un dado). Utilizando los métodos estáticos de la clase Collections
guarda en otro ArrayList la distribución de resultados obtenidos (cuantas veces ha salido
el uno, cuantas veces ha salido el dos, etc...) y muestra su contenido. Finalmente,
también mediante métodos de Collections, mostrar la diferencia de veces entre el
número que más ha salido y el que menos ha salido
 */


package ArrayList.E_5;

import java.util.ArrayList;
import java.util.Collections;

public class E_5{
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i=1; i<=10000; i++){
            nums.add( (int) (Math.random() * 6 + 1) );
        }


        ArrayList<Integer> stats = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            stats.add(Collections.frequency(nums, i));
        }

        for (int i = 0; i < stats.size(); i++) {
            System.out.println((i+1)+": "+stats.get(i));
        }
        System.out.println("Dif: "+(Collections.max(stats)-Collections.min(stats)));

    }
}
