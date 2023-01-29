/*
Ejercicio 2- Divisores
Realizar un programa que tenga una función a la que se le pasa un entero y devuelva un
ArrayList con todos sus divisores.
*/

package ArrayList.E_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E_2 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Dime un numero");

        System.out.println("Sus divisores son: "+divisores(readAndValidate()));

    }

    public static ArrayList<Integer> divisores (int num){
        ArrayList<Integer> divs = new ArrayList<>();

        for (int i=1;i<=num;i++){
            if(num%i==0)
                divs.add(i);
        }

        return divs;
    }

    public static int readAndValidate(){
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("-?\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("Datos introducidos no validos, intentelo de nuevo.");
        }
    }













}
