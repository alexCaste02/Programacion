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

package E_01;

import java.util.*;

public class E_1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Object> alturaAlumnos = new ArrayList<>();

        while (menu(alturaAlumnos));

    }



    public static boolean menu(ArrayList<Object> list){
        System.out.println("""
                Elige una opcion:
                
                a) Añadir altura.
                b) Mostrar lista actual con el número de posición.
                c) Eliminar por posición. Se le pasa como parámetro una posición y elimina la altura en dicha posición.
                d) Eliminar por valor. Se le pasa como parámetro una altura y elimina todas las posiciones en las que se encuentre dicha altura. Devuelve la cantidad de eliminaciones.
                e) Ordenar la lista
                
                x) Salir

                """);

        switch (readAndValidateOption()) {

            case 'a' -> addAltura(list);

            case 'b' -> showAlturas(list);

            case 'c' -> removePosAlturas(list,0);

            case 'd'-> removeValueAlturas(list);

            case 'e'-> sortAlturas(list);


            case 'x' -> { return exit(); }

        }

        return true;

    }

    public static char readAndValidateOption(){
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[a-e]|x"))
                return inputLine.charAt(0);

            System.out.println("El caracter introducido no es una opcion valida, vuelve a intentarlo");
        }
    }

    public static double readAndValidateAltura(){

        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[0-2]([.]\\d+)")
                    && Double.parseDouble(inputLine)>=0.5
                    && Double.parseDouble(inputLine)<=2.5) {
                return Double.parseDouble(inputLine);
            } else{
                System.out.println("La altura introducida no es valida, vuelve a intentarlo");
            }
        }
    }

    public static void addAltura(ArrayList<Object> list){
        System.out.println("Introduce la altura del alumno a añadir");
        list.add(readAndValidateAltura());
        System.out.println("Altura añadida!");

    }

    public static void showAlturas(ArrayList<Object> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Altura " + (i + 1) + ": " + list.get(i));
        }
    }

    //FIXME: -USAR POS COMO PARAM
    public static void removePosAlturas(ArrayList<Object> list, int pos){
        System.out.println("Introduce la posicion que quieres eliminar");

        boolean valido = false;
        while (!valido){
            String inputLine = input.nextLine();
            if (inputLine.matches("\\d")
                    && Integer.parseInt(inputLine) <= list.size()) {
                list.remove( Integer.parseInt(inputLine)-1 );
                valido=true;
                System.out.println("Posicion "+(Integer.parseInt(inputLine)-1)+" borrada correctamente");
            } else{
                System.out.println("La posicion introducida no es valida, vuelve a intentarlo");
            }
        }

    }

    public static void removeValueAlturas(ArrayList<Object> list){
        System.out.println("Introduce el valor que quieres eliminar");
        Object AlturaToRemove = readAndValidateAltura();
        int count=0;
        while (list.remove(AlturaToRemove)){
            count++;
        }
        System.out.println(count+" instancias de "+AlturaToRemove+" borradas correctamente");
    }

    public static void sortAlturas(ArrayList<Object> list){
        System.out.println("Ordenando lista...");
        Collections.sort((List) list);
        System.out.println("Lista ordenada con exito!");
    }

    public static boolean exit(){
        System.out.println("Saliendo...");
        return false;
    }











}
