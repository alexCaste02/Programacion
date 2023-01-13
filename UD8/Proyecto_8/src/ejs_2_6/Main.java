package ejs_2_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Trabajador t1 = new Trabajador();
        t1.leerTrabajador();
        leerTrabajador(t1);

        System.out.println(t1);


    }


    public static void leerTrabajador(Trabajador t1){
        Scanner input = new Scanner(System.in);


        System.out.print("Nombre: ");
        t1.setNombre(input.nextLine());

        // TODO: 13/01/2023 -Validar DNI (copiar de antes)
        System.out.print("DNI: ");
        DNI=input.nextLine();

        System.out.print("Sueldo Base: ");
        sueldoBase=input.nextDouble();

        // TODO: 13/01/2023 -Quitar negativos
        System.out.print("Horas Extra: ");
        horasExtra=input.nextInt();

        // TODO: 13/01/2023 -Poner limites
        System.out.print("Sueldo Base: ");
        tipoIRPF=input.nextDouble();

    }

}