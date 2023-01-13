package ejs_2_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.print("Introduce el precio de las horas extraordinarias: ");
        Trabajador.setImporteHoraExtra(Double.parseDouble(input.nextLine())); // 20 en el ejemplo


        Trabajador t1 = new Trabajador();
        t1.leerTrabajador();


        Trabajador t2 = new Trabajador();
        leerTrabajador(t2);


        System.out.print("Nombre: ");
        String nombre=input.nextLine();

        System.out.print("DNI: ");
        String dni=input.nextLine();

        System.out.print("Sueldo Base: ");
        double sueldoBase=input.nextDouble();

        System.out.print("Horas Extra: ");
        int horasExtra=input.nextInt();

        System.out.print("Sueldo Base: ");
        double tipoIRPF=input.nextDouble();

        Trabajador t3 = new Trabajador(nombre, dni, sueldoBase, horasExtra, tipoIRPF);


        System.out.println(Trabajador.getNumTrabajadores());

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }


    public static void leerTrabajador(Trabajador t1){

        Scanner input = new Scanner(System.in);


        System.out.print("Nombre: ");
        t1.setNombre(input.nextLine());

        // TODO: 13/01/2023 -Validar DNI (copiar de antes)
        System.out.print("DNI: ");
        t1.setDNI(input.nextLine());

        System.out.print("Sueldo Base: ");
        t1.setSueldoBase(input.nextDouble());

        // TODO: 13/01/2023 -Quitar negativos
        System.out.print("Horas Extra: ");
        t1.setHorasExtra(input.nextInt());

        // TODO: 13/01/2023 -Poner limites
        System.out.print("Sueldo Base: ");
        t1.setTipoIRPF(input.nextDouble());

    }

}