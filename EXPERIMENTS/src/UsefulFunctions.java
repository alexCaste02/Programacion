import java.util.Scanner;

public class UsefulFunctions {

    static Scanner input = new Scanner(System.in);

    /**
     * Empieza a leer por teclado una linea de texto
     * Bucle hasta que se introduzca un numero valido
     *
     * @return Int validado
     */
    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }


}
