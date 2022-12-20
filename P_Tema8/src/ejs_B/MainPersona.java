package ejs_B;

import java.util.Scanner;

/*
En el main de la clase principal instancia dos objetos de la clase Persona. Luego, pide por
teclado los datos de ambas personas (guárdalos en los objetos). Por último, imprime dos
mensajes por pantalla (uno por objeto) con un mensaje del estilo “Azucena Luján García
con DNI ... es / no es mayor de edad”.
*/

public class MainPersona {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Persona per1 = new Persona();
        Persona per2 = new Persona();

        System.out.println("Introduce el nombre de la persona: ");
        per1.nombre = input.nextLine();
        System.out.println("Introduce el DNI de la persona: ");
        per1.dni = input.nextLine();
        System.out.println("Introduce los apellidos de la persona");
        per1.apellidos = input.nextLine();
        System.out.println("Introduce la edad");
        per1.edad= Integer.parseInt(input.nextLine());

        System.out.println("Introduce el nombre de la persona: ");
        per2.nombre = input.nextLine();
        System.out.println("Introduce el DNI de la persona: ");
        per2.dni = input.nextLine();
        System.out.println("Introduce los apellidos de la persona");
        per2.apellidos = input.nextLine();
        System.out.println("Introduce la edad");
        per2.edad= Integer.parseInt(input.nextLine());

        System.out.println(per1.nombre+" "+per1.apellidos+" con DNI "+per1.dni+((per1.edad<18)?" no ":"")+"es mayor de edad");
        System.out.println(per2.nombre+" "+per1.apellidos+" con DNI "+per2.dni+((per2.edad<18)?" no ":"")+"es mayor de edad");

    }
}