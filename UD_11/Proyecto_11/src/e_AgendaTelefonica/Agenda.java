package e_AgendaTelefonica;

import java.util.*;


public class Agenda {
    
    static Scanner input = new Scanner(System.in);

    //TODO: Preguntar final en listas
    private static final List<Registro> registros = new ArrayList<>();
    
    public static void mostrarAgenda() {
        System.out.println(registros.isEmpty()?
                "La agenda esta vacia":
                registros
        );
    }

    public static void addEntrada() {
        System.out.print("Introduce el nombre:");
        String nombre = input.nextLine();

        System.out.print("Introduce el telefono: ");
        String telefono = input.nextLine();

        registros.add(new Registro(nombre, telefono));
    }

    public static void buscarPorNombre() {
        System.out.println("Introduce un nombre");
        String nombre = input.nextLine();

        for (Registro registro : registros) {
            if(registro.nombre().equalsIgnoreCase(nombre)) System.out.println(registro);
        }
    }

    public static void buscarPorNumero() {
        System.out.print("Introduce un telefono: ");
        String telefono = input.nextLine();

        for (Registro registro : registros) {
            if(registro.telefono().equalsIgnoreCase(telefono)) System.out.println(registro);
        }
    }

    public static void borrarPorNombre() {
        System.out.println("Introduce un nombre");
        String nombre = input.nextLine();

        registros.removeIf(registro -> registro.nombre().equalsIgnoreCase(nombre));

//        Iterator<Registro> iter = registros.iterator();
//        while (iter.hasNext()){
//            Registro registro = iter.next();
//            if(registro.nombre().equalsIgnoreCase(nombre))
//                iter.remove();
//        }
    }

    public static void borrarPorNumero() {
        System.out.print("Introduce un telefono: ");
        String telefono = input.nextLine();

        registros.removeIf(registro -> registro.telefono().equalsIgnoreCase(telefono));
    }

    public static void ordenarPorNombre() {
//        registros.sort(new Comparator<Registro>() {
//            @Override
//            public int compare(Registro o1, Registro o2) {
//                return o1.nombre().compareTo(o2.nombre());
//            }
//        });

        registros.sort(Comparator.comparing(Registro::nombre));

        System.out.println((registros.isEmpty())?
                "La agenda esta vacia":
                registros
        );
    }
}
