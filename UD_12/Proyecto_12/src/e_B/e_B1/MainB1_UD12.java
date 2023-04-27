package e_B.e_B1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainB1_UD12 {
    public static void main(String[] args) {


        try (Scanner scf = new Scanner(new File("UD_12/Proyecto_12/DOCS/numeros.txt"))){

            Integer max = null;
            Integer min = null;
            while (scf.hasNextInt()) {
                int num = scf.nextInt();
                if(max == null){
                    max=min=num;
                }


                max = Math.max(num, max);
                min = Math.min(num, min);
            }

            System.out.println("Maximo: " + max);
            System.out.println("Minimo: " + min);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}