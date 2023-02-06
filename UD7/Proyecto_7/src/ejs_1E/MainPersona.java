package ejs_1E;

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

        //investigar si se puede meter en una linea

        System.out.println("Introduce el nombre de la persona: ");
        String nombre = input.nextLine();
        System.out.println("Introduce el DNI de la persona: ");
        String dni = input.nextLine();
        System.out.println("Introduce los apellidos de la persona");
        String apellidos = input.nextLine();
        System.out.println("Introduce la edad");
        int edad = Integer.parseInt(input.nextLine());

        Persona per1 = new Persona(dni,nombre,apellidos,edad);


//        System.out.println("Introduce el nombre de la persona: ");
//        nombre = input.nextLine();
//        System.out.println("Introduce el DNI de la persona: ");
//        dni = input.nextLine();
//        System.out.println("Introduce los apellidos de la persona");
//        apellidos = input.nextLine();
//        System.out.println("Introduce la edad");
//        edad= Integer.parseInt(input.nextLine());
//
        Persona per2 = new Persona("51796121Y","nombre","apellidos",15);
//
//        per2.setNombre("Nombre");
//        per2.setApellidos("Ap1 Ap2");
//        per2.setDni("51879xxxxy");
//        per2.setEdad(15);


//        System.out.println(per1.getNombre()+" "+per1.getApellidos()+" con DNI "+per1.getDni()+((per1.getEdad()<18)?" no":"")+" es mayor de edad");
//        System.out.println(per2.getNombre()+" "+per2.getApellidos()+" con DNI "+per2.getDni()+((per2.getEdad()<18)?" no":"")+" es mayor de edad");

        per1.imprime();
        System.out.println(per1.esMayorEdad()?"es mayor de edad":"no es mayor de edad");
        System.out.println(per1.esJubilado()?"es jubilado":"no es jubilado");

        System.out.println("La diferencia de edad es de "+per1.diferenciaEdad(per2)+" años");

    }
}