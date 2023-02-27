package e_07;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Gato> gatoLista = new ArrayList<>();

        while (gatoLista.size()<5){

            String name;
            int age=0;

            System.out.print("dime el nombre del gato: ");
            name = input.nextLine();
            System.out.print("dime la edad del gato: ");

            try{
                age = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            try {
                gatoLista.add( new Gato(name,age) );
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }




        }

        for (Gato gato : gatoLista) {
            System.out.println(gato.getNombre());
            System.out.println(gato.getEdad());
        }

    }
}
