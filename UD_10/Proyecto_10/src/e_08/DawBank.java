package e_08;

import java.util.ArrayList;
import java.util.Scanner;
import custom.util.InputReader;
import custom.util.InvalidInputException;

public class DawBank {

    static Scanner input = new Scanner(System.in);
    static ArrayList<CuentaBancaria> listaCuentas = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("======================================================================================================\n");

        //CuentaBancaria cuenta1 = crearCuenta(); // ES1234567890123456789012
        menuInicial();

    }



    public static void menuInicial() {

        boolean repeat = true;
        do {
            System.out.println("""
                    Que accion desea realizar:

                    (1) Crear una cuenta nueva
                    (2) Consultar una cuenta existente

                    (0) Salir
                    """);

            try {
                switch (InputReader.readAndValidateOption(2)) {
                    case 1 -> crearCuenta();
                    case 2 -> menuCuenta();

                    case 0 -> {
                        System.out.println("Finalizando programa...");
                        repeat = false;
                    }
                }

            } catch (CuentaException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }


        } while (repeat);


    }

    public static void crearCuenta() throws CuentaException {

        String titular, iban;


        System.out.print("Introduce el nombre del titular: ");
        titular = input.nextLine();

        input.next();

        System.out.print("Introduce el IBAN: ");
        iban = input.next();

        esValidoIBAN(iban);


        System.out.println("\n\n===== Cuenta creada con exito! =====\n");

        listaCuentas.add(new CuentaBancaria(titular, iban));

    }

    public static void menuCuenta() throws CuentaException {

        System.out.print("Introduce el IBAN de la cuenta a la que desea entrar: ");
        String iban = input.next();

        esValidoIBAN(iban);

        CuentaBancaria cuenta = findCuenta(iban);

        //variable conveniente
        boolean repeat = true;

        System.out.println("\n\n===== Cuenta accedida =====\n");
        do {

            System.out.print("""
                    Que accion desea realizar:
                                    
                    (1) Datos de la cuenta
                    (2) IBAN
                    (3) Titular
                    (4) Saldo
                    (5) Ingreso
                    (6) Retirada
                    (7) Mostrar movimientos
                                    
                    (0) Salir
                                    
                    >""");

            try {
                switch (InputReader.readAndValidateOption(7)) {

                    case 1 -> System.out.println(cuenta);

                    case 2 -> System.out.printf("""
                                ==============================================
                                IBAN: %s
                                ==============================================
                                """,cuenta.getIBAN());

                    case 3 -> System.out.printf("""
                                ==============================================
                                IBAN: %s
                                ==============================================
                                """,cuenta.getTITULAR());

                    case 4 -> System.out.printf("""
                                ==============================================
                                IBAN: %s
                                ==============================================
                                """,cuenta.getSaldo());

                    case 5 -> {

                        System.out.print("""
                                ==============================================
                                Introduce la cantidad de dinero a ingresar:
                                """);

                        try {
                            cuenta.ingresar(InputReader.readAndValidateDouble());
                        } catch (InvalidInputException | SaldoInvalidoException e) {
                            System.out.println(e.getMessage());
                        } catch (AvisarHaciendaException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }

                        System.out.println("==============================================\n");
                    }

                    case 6 -> {
                        System.out.print("""
                                ==============================================
                                Introduce la cantidad de dinero a retirar:
                                """);

                        try {
                            cuenta.retirar(InputReader.readAndValidateDouble());
                        } catch (InvalidInputException | SaldoInvalidoException e) {
                            System.out.println(e.getMessage());
                        } catch (AvisarHaciendaException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }

                        System.out.println("==============================================\n");
                    }

                    case 7 -> {
                        System.out.print("""
                                ==============================================
                                Movimientos:
                                """);

                        System.out.println(cuenta.getMovimientos());
                        System.out.println("==============================================\n");

                    }
                    case 0 -> {
                        System.out.println("""
                            
                            ==============================================
                            Finalizando programa...
                            ==============================================
                            """);

                        repeat = false;
                    }

                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }


        } while (repeat);
    }

    public static void esValidoIBAN(String iban) throws CuentaException {
        if(!iban.toUpperCase().matches("[A-Z]{2}\\d{22}")) {
            throw new CuentaException("IBAN invalido");
        }
    }

    public static CuentaBancaria findCuenta(String inputIBAN) throws CuentaException{
        for (CuentaBancaria cuenta : listaCuentas) {
            if (cuenta.getIBAN().equals(inputIBAN))
                return cuenta;
        }
        throw new CuentaException("");
    }

}
