package E_8;

import java.util.Scanner;

public class ValidateInput {

    static Scanner input = new Scanner(System.in);

    public static int readAndValidateInt(){
        while(true){
            String inputLine = input.nextLine();
            if (inputLine.matches("-?\\d+"))
                return Integer.parseInt(inputLine);
            System.out.println("No ha introducido un numero entero. Vuelve a intentarlo.");
        }
    }

    public static double readAndValidateDouble(){
        while(true){
            String inputLine = input.nextLine();
            if (inputLine.matches("-?\\d+([.]\\d+)?"))
                return Double.parseDouble(inputLine);
            System.out.println("No ha introducido un numero decimal. Vuelve a intentarlo.");
        }
    }


}
