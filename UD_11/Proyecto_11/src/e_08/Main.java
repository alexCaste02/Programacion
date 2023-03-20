package e_08;

import custom.util.InputReader;
import custom.util.InvalidInputException;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Introduce un año");
        int year=0;
        try {
            year = InputReader.readAndValidateInt();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        int[] arrayTemps = (year%4==0 && !(year%100==0) || year%400==0)?
                new int[365]:
                new int[366];

        for (int i = 0; i < arrayTemps.length; i++) {
            arrayTemps[i] = (int) (Math.random()*21+10);
        }

        Map<Integer,Integer> distribTemps = new TreeMap<>();

        for (int temp : arrayTemps) {
            if(distribTemps.containsKey(temp))
                distribTemps.put(temp,distribTemps.get(temp)+1);
            else
                distribTemps.put(temp,0);
        }

        for (Integer key : distribTemps.keySet()) {
            System.out.println(key+": "+distribTemps.get(key));
        }

    }
}
