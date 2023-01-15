package ejs_2_8;

import java.util.Scanner;

public class DawBank {

    public static void main(String[] args) {

        CuentaBancaria cuenta1 = crearCuenta();
        menuCuenta(cuenta1);

    }

    //Esto seria util en caso de tener arrays

//    public static void menuInicial() {
//
//        Scanner input = new Scanner(System.in);
//
//        boolean repeat = true;
//        do {
//            System.out.println("""
//                    Que accion desea realizar:
//
//                    (1) Crear una cuenta nueva
//                    (2) Consultar una cuenta existente
//
//                    (0) Salir
//                    """);
//
//
//            switch (input.nextInt()) {
//                case 1:
//                    crearCuenta();
//                case 2:
//                    menuCuenta();
//                case 0: {
//                    System.out.println("Finalizando programa...");
//                    repeat = false;
//                }
//                default:
//                    System.out.println("Introduzca un valor correcto");
//
//            }
//
//        } while (repeat);
//
//
//    }

    public static CuentaBancaria crearCuenta() {

        Scanner input = new Scanner(System.in);

        String titular, iban;


        System.out.print("Introduce el nombre del titular: ");
        titular = input.nextLine();

        //Tenemos que generarlo aleatoriamente?
        do {
            System.out.print("Introduce el IBAN: ");
            iban = input.next();
            System.out.println(esValidoIBAN(iban)?"IBAN valido":"IBAN invalido, vuelve a intentarlo");
        } while (!esValidoIBAN(iban));

        System.out.println("\n=== Cuenta creada con exito! ===");

        return (new CuentaBancaria(titular,iban));

    }

    public static void menuCuenta(CuentaBancaria cuenta) {

        Scanner input = new Scanner(System.in);

        System.out.println("""
                Que accion desea realizar:
                                
                (1) Datos de la cuenta
                (2) IBAN
                (3) Titular
                (4) Saldo
                (5) Ingreso
                (6) Retirada
                                
                (7) Salir
                """);

        //variables convenientes
        boolean repeat = true;
        boolean valido = false;
        double dinero;

        do {
            valido = false; //resetear valido (para ingreso y retiro

            switch (input.nextInt()) {
                case 1 -> {
                    System.out.println(cuenta);
                    break;
                }
                case 2 -> {
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    break;
                }
                case 3 -> {
                    System.out.println("Titular: " + cuenta.getTITULAR());
                    break;
                }
                case 4 -> {
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;
                }
                case 5 -> {
                    do {
                        System.out.print("Introduce la cantidad de dinero a ingresar: ");

                        valido = cuenta.ingresar(input.nextDouble());
                        System.out.println(valido ? "Operacion realizada con exito" : "Operacion fallida. Introduzca un valor superior a 0");

                    } while (!valido);
                    break;
                }
                case 6 -> {
                    do {
                        System.out.print("Introduce la cantidad de dinero a retirar: ");

                        switch (cuenta.retirar(input.nextDouble())) {
                            case -1:
                                System.out.println("Operacion fallida. Saldo insuficiente (Balance resultante seria menor de-50)");
                            case 0:
                                System.out.println("Operacion fallida. Introduzca un valor superior a 0");
                            case 1:
                                System.out.println("Operacion realizada con exito");
                                valido = true;
                        }

                    } while (!valido);
                    break;
                }
                case 7 -> {
                    System.out.println("Finalizando programa...");
                    repeat = false;
                    break;
                }
                default -> {
                    System.out.println("Introduzca un valor de operacion correcto");
                    break;
                }
            }

        }while (repeat);
    }

    public static boolean esValidoIBAN(String iban){
        return iban.toUpperCase().matches("[A-Z]{2}\\d{22}");
    }

}
