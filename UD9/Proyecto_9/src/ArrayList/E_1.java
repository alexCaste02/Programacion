/*
Ejercicio 1 – Alturas
Realiza un programa que tenga un ArrayList llamado AlturaAlumnos que mantenga una
lista con las alturas de los alumnos de un centro. Serán valores positivos entre 0,50 y 2,50
redondeados a dos decimales. El programa tendrá las siguientes funciones (accesibles
mediante un menú):
a) Añadir altura.
b) Mostrar lista actual con el número de posición.
c) Eliminar por posición. Se le pasa como parámetro una posición y elimina la altura
en dicha posición.
d) Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las
posiciones en las que se encuentre dicha altura. Devuelve la cantidad de
eliminaciones.
e) Ordenar la lista
*/

package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class E_1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Object> alturaAlumnos = new ArrayList<>();

        menu(alturaAlumnos);


    }

    public static char readAndValidateOption(){
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[a-e]"))
                return inputLine.charAt(0);

            System.out.println("El caracter introducido no es valido, vuelve a intentarlo");
        }
    }

    public static double readAndValidateAltura(){
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[0-2]([.]\\d+)")
                    && Double.parseDouble(inputLine)>=0.5
                    && Double.parseDouble(inputLine)<=0.5) {
                return Double.parseDouble(inputLine);
            }

            System.out.println("La altura introducida no es valida, vuelve a intentarlo");
        }
    }


    public static void menu(ArrayList<Object> list){
        System.out.println("""
                Elige una opcion:
                
                a) Añadir altura.
                b) Mostrar lista actual con el número de posición.
                c) Eliminar por posición. Se le pasa como parámetro una posición y elimina la altura
                en dicha posición.
                d) Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las
                posiciones en las que se encuentre dicha altura. Devuelve la cantidad de
                eliminaciones.
                e) Ordenar la lista

                """);
        switch (readAndValidateOption()){
            case 'a':
                System.out.println("Introduce la altura del alumno");
                list.add(readAndValidateAltura());
                break;
            case 'b':
                System.out.println(list);
                break;
            case 'c':
                System.out.println("Introduce la altura del alumno");

                break;
            case 'd':
                break;
            case 'e':
                break;

        }

    }



}
