import java.util.Scanner;

public class UsefulFunctions {

    static Scanner input = new Scanner(System.in);

    //valida si es un numero
    public static int leerInput() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

}
