package e_B.e_B6;

/*
Implementa un programa que pida al usuario un número de cualquier longitud, como
por ejemplo “1234”, y le diga al usuario si dicho número aparece en el primer millón de
decimales del nº pi (están en el archivo ‘pi-million.txt’). No está permitido utilizar ninguna
librería ni clase ni método que realice la búsqueda. Debes implementar el algoritmo de
búsqueda tú.
 */


import java.io.*;
import java.util.Scanner;

public class MainB6_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un numero");
        String num = input.nextLine();

        int pos = -1;

        try(BufferedReader reader = new BufferedReader(new FileReader("UD_12/Proyecto_12/DOCS/pi-million.txt")) ){
            String linea = reader.readLine();
            for (int i = 0; i <= linea.length() - num.length() ; i++) {
//              if (linea.substring(i, i+num.length()).equals(num))
                if (linea.startsWith(num, i)) {
                    pos = i+1;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if(pos!=-1) System.out.println(num+" aparece en la posicion "+pos);
        else System.out.println(num+" no aparece");



    }
}
