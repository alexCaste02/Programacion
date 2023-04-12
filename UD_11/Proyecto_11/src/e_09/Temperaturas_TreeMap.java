package e_09;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Temperaturas_TreeMap {
    public static void main(String[] args) {


        //tamaño array segun bisiesto
        int[] arrayTemps = new int[364];


        //generar temps para dias
        for (int i = 0; i < arrayTemps.length; i++) {
            arrayTemps[i] = (int) (Math.random() * 21 + 10);
        }

        //Mapa distribucion de temps
        //k: temp, v: reps
        TreeMap<Integer, Integer> distribTemps = new TreeMap<>();

        //contamos repeticiones de temps
        for (int temp : arrayTemps) {
            if (distribTemps.containsKey(temp))
                distribTemps.put(temp, distribTemps.get(temp) + 1);
            else
                distribTemps.put(temp, 1);
        }

        //mostramos temps y reps
        for (Map.Entry<Integer, Integer> entry : distribTemps.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

        //minima y maxima
        System.out.println("Minima: " + distribTemps.firstKey() + " (Reps: " + distribTemps.get(distribTemps.firstKey()) + ")");
        System.out.println("Maxima: " + distribTemps.lastKey() + " (R: " + distribTemps.get(distribTemps.lastKey()) + ")");


    }


}
