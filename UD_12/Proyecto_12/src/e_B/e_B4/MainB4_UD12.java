package e_B.e_B4;

/*
Implementa un programa que genere aleatoriamente nombres de persona (combinando
nombres y apellidos de ‘usa_nombres.txt’ y ‘usa_apellidos.txt’). Se le pedirá al usuario
cuántos nombres de persona desea generar y a qué archivo añadirlos (por ejemplo
‘usa_personas.txt’)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainB4_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Cuantos nombres quieres generar");
        int n = Integer.parseInt(input.nextLine());

        System.out.println("En que archivo quieres guardarlo?");
        String txt = input.nextLine();
        File destino = new File("UD_12/Proyecto_12/DOCS/"+txt);

        ArrayList<String> listaNombres = new ArrayList<>();
        ArrayList<String> listApellidos = new ArrayList<>();

        try(Scanner scf1 = new Scanner(new File("UD_12/Proyecto_12/DOCS/usa_nombres.txt"));
        Scanner scf2 = new Scanner(new File("UD_12/Proyecto_12/DOCS/usa_apellidos.txt"));
        PrintWriter pw = new PrintWriter(destino))
        {
            while (scf1.hasNext() && scf2.hasNext()){
                listaNombres.add(scf1.next());
                listApellidos.add(scf2.next());
            }

            for (int i = 0; i < n; i++) {
                pw.println(
                        listaNombres.get(ThreadLocalRandom.current().nextInt(listaNombres.size()))
                        +" "+
                        listApellidos.get(ThreadLocalRandom.current().nextInt(listApellidos.size()))
                );
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
