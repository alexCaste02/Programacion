package e_13;

import ReaderAndValidator.InputReader;
import ReaderAndValidator.InvalidInputException;

import java.util.*;

public class TemperaturasPorValor {
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

            for (Map.Entry<Integer, Integer> entry : distribTemps.entrySet()) {
                System.out.println("Temp: "+entry.getKey()+" - Reps: "+entry.getValue());
            }

            ArrayList<Map.Entry<Integer,Integer>> orderedList = new ArrayList<>(distribTemps.entrySet());
            // orderedList.sort((o1, o2) -> o1.getValue() - o2.getValue());
            orderedList.sort(Comparator.comparingInt(Map.Entry::getValue));

            System.out.println("\n");

            for (Map.Entry<Integer, Integer> entry : orderedList) {
                System.out.println("Temp: "+entry.getKey()+" - Reps: "+entry.getValue());
            }


        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

    }
}
