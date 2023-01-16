package ejs_2_8;

import java.util.Scanner;

public class DawBank {

    public static void main(String[] args) {

        System.out.println("======================================================================================================\n");

        CuentaBancaria cuenta1 = crearCuenta(); // ES1234567890123456789012
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

            System.out.print(esValidoIBAN(iban) ?
                    "IBAN valido" :
                    "IBAN invalido, vuelve a intentarlo");

        } while (!esValidoIBAN(iban));

        System.out.println("\n\n===== Cuenta creada con exito! =====\n");

        return (new CuentaBancaria(titular, iban));

    }

    public static void menuCuenta(CuentaBancaria cuenta) {

        Scanner input = new Scanner(System.in);


        //variables convenientes
        boolean repeat = true;

        do {

            System.out.print("""
                    Que accion desea realizar:
                                    
                    (1) Datos de la cuenta
                    (2) IBAN
                    (3) Titular
                    (4) Saldo
                    (5) Ingreso
                    (6) Retirada
                                    
                    (7) Salir
                                    
                    >""");

            switch (input.nextInt()) {
                case 1 -> {
                    System.out.println(cuenta);
                }
                case 2 -> {
                    System.out.println(
                            "\n==============================================\n" +
                            "IBAN: " + cuenta.getIBAN() +
                            "\n==============================================\n"
                    );
                }
                case 3 -> {
                    System.out.println(
                            "\n==============================================\n"+
                            "Titular: " + cuenta.getTITULAR()+
                            "\n==============================================\n"
                    );
                }
                case 4 -> {
                    System.out.println(
                            "\n==============================================\n"+
                            "Saldo: " + cuenta.getSaldo()+
                            "\n==============================================\n"
                    );
                }
                case 5 -> {

                    System.out.print(
                            "\n==============================================\n"+
                            "Introduce la cantidad de dinero a ingresar: "
                    );

                    System.out.println(
                            cuenta.ingresar( input.nextDouble() )?
                                "\nOperacion realizada con exito":
                                "\nOperacion fallida. Introduzca un valor superior a 0"
                    );

                    System.out.println("==============================================\n");
                }
                case 6 -> {
                    System.out.print(
                            "\n==============================================\n"+
                            "Introduce la cantidad de dinero a retirar: "
                    );

                    switch (cuenta.retirar(input.nextDouble())) {
                        case -1 -> {
                            System.out.println("\nOperacion fallida. Saldo insuficiente (Balance resultante seria menor de -50)");
                        }
                        case 0 -> {
                            System.out.println("\nOperacion fallida. Introduzca un valor superior a 0");
                        }
                        case 1 -> {
                            System.out.println("\nOperacion realizada con exito");

                        }
                    }

                    System.out.println("==============================================\n");
                }
                case 7 -> {
                    System.out.println("""
                            
                            ==============================================
                            Finalizando programa...
                            ==============================================
                            """);

                    repeat = false;
                }
                default -> {
                    System.out.println("""
                            
                            ==============================================
                            Introduzca un valor de operacion correcto
                            ==============================================
                            """);
                }
            }

        } while (repeat);
    }

    public static boolean esValidoIBAN(String iban) {
        return iban.toUpperCase().matches("[A-Z]{2}\\d{22}");
    }

}
