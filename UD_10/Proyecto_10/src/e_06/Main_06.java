package e_06;

import java.util.Scanner;

public class Main_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name="cat";
        int age;
        Gato catto = null;
        do {

            try {
                System.out.println("Introduce el nombre del gato");
                name= input.nextLine();
                System.out.println("su edad");
                age= Integer.parseInt(input.nextLine());

                catto = new Gato(name, age);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } while (!name.equals("cat"));
        System.out.println("check 1");

        try {

            if (catto!=null) {
                catto.setNombre("gatuno");
                catto.setEdad(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("check 2");

        try {

            if (catto!=null) {
                catto.setNombre("gatuno");
                catto.setEdad(-1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("check 3");
    }
}
