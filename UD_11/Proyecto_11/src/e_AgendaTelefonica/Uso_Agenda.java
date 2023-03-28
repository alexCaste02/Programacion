package e_AgendaTelefonica;

import custom.util.InputReader;
import custom.util.InvalidInputException;

import java.util.Comparator;

import java.util.Scanner;

public class Uso_Agenda {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (menu());
    }

    public static boolean menu() {

        System.out.print("""
                =============================================
                Introduzca la accion a realizar:
                
                1) Mostrar Agenda
                
                2) Añadir entrada
                
                3) Buscar por nombre
                4) Buscar por numero
                
                5) Borrar por nombre
                6) Borrar por numero
                
                7) Ordenar por nombre
                
                0) Salir
                =============================================
                """);

        try {
            switch (InputReader.readAndValidateOption(7)) {
                case 1 -> mostrarAgenda();
                case 2 -> addEntrada();
                case 3 -> buscarPorNombre();
                case 4 -> buscarPorNumero();
                case 5 -> borrarPorNombre();
                case 6 -> borrarPorNumero();
                case 7 -> ordenarPorNombre();
                case 0 -> {
                    return false;
                }
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }


    private static void mostrarAgenda() {

        System.out.println((Agenda.getRegistros().isEmpty())?
                "La agenda esta vacia":
                Agenda.getRegistros()
        );

    }

    private static void addEntrada() {
        System.out.print("Introduce el nombre:");
        String nombre = input.nextLine();

        System.out.print("Introduce el telefono: ");
        String telefono = input.nextLine();

        Agenda.getRegistros().add(new Registro(nombre, telefono));

    }

    private static void buscarPorNombre() {
        System.out.println("Introduce un nombre");
        String nombre = input.nextLine();

        for (Registro registro : Agenda.getRegistros()) {
            if(registro.nombre().equalsIgnoreCase(nombre)) System.out.println(registro);
        }
    }

    private static void buscarPorNumero() {
        System.out.print("Introduce un telefono: ");
        String telefono = input.nextLine();

        for (Registro registro : Agenda.getRegistros()) {
            if(registro.telefono().equalsIgnoreCase(telefono)) System.out.println(registro);
        }
    }

    private static void borrarPorNombre() {
        System.out.println("Introduce un nombre");
        String nombre = input.nextLine();

        Agenda.getRegistros().removeIf(registro -> registro.nombre().equalsIgnoreCase(nombre));

//        Iterator<Registro> iter = Agenda.getRegistros().iterator();
//        while (iter.hasNext()){
//            Registro registro = iter.next();
//            if(registro.nombre().equalsIgnoreCase(nombre))
//                iter.remove();
//        }


    }

    private static void borrarPorNumero() {
        System.out.print("Introduce un telefono: ");
        String telefono = input.nextLine();

        Agenda.getRegistros().removeIf(registro -> registro.telefono().equalsIgnoreCase(telefono));
    }

    private static void ordenarPorNombre() {

//        Agenda.getRegistros().sort(new Comparator<Registro>() {
//            @Override
//            public int compare(Registro o1, Registro o2) {
//                return o1.nombre().compareTo(o2.nombre());
//            }
//        });

        Agenda.getRegistros().sort(Comparator.comparing(Registro::nombre));

        System.out.println((Agenda.getRegistros().isEmpty())?
                "La agenda esta vacia":
                Agenda.getRegistros()
        );
    }
}
