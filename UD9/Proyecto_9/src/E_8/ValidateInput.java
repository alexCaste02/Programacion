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

    public static int readAndValidateOption(){
        while(true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[1-5]"))
                return Integer.parseInt(inputLine);
            System.out.println("No ha introducido una opcion valida. Vuelve a intentarlo.");
        }
    }

    public static boolean readAndValidateYN(){
        while(true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[Yy]"))
                return true;
            else if(inputLine.matches("[Nn]")){
                return false;
            }
            System.out.println("No ha introducido una opcion valida. Vuelve a intentarlo.");
        }
    }


}
