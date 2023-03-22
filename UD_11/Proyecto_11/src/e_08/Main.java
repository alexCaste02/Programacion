package e_08;

import custom.util.InputReader;
import custom.util.InvalidInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Introduce un año");
        int year;

        try {

            year = InputReader.readAndValidateInt();

            //tamaño array segun bisiesto
            int[] arrayTemps = (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0) ?
                    new int[364] :
                    new int[365];

            //generar temps para dias
            for (int i = 0; i < arrayTemps.length; i++) {
                arrayTemps[i] = (int) (Math.random() * 21 + 10);
            }

            //Mapa distribucion de temps
            //k: temp, v: reps
            Map<Integer, Integer> distribTemps = new HashMap<>();

            //contamos repeticiones de temps
            for (int temp : arrayTemps) {
                if (distribTemps.containsKey(temp))
                    distribTemps.put(temp, distribTemps.get(temp) + 1);
                else
                    distribTemps.put(temp, 1);
            }

            //mostramos temps y reps
            for (Integer key : distribTemps.keySet()) {
                System.out.println(key + ": " + distribTemps.get(key));
            }

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

    }
}
