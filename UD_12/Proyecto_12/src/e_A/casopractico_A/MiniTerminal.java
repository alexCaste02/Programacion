package e_A.casopractico_A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MiniTerminal {
    public static void main(String[] args) {

        boolean repeat = true;

        Scanner input = new Scanner(System.in);

        System.out.print("""
                 ====  MiniTerminal LinuxEmu  ====
                 === (c) Alejandro Castellanos ===
                                  
                Escribe "help" para obtener los comandos disponibles
                """
        );
        do {

            System.out.print("\n> ");
            //FIXME: como tratar con espacios en ruta?
            String enter = input.nextLine();

            String cmd;
            String ruta1 = "";
            String ruta2 = "";


                String[] line = enter.split(" ");
                cmd = line[0];


                // SE PUEDE TRATAR A TRAVES DE INDEXOUTOFBOUNDS EN VEZ DE TRATAR LA INFO CON PARAMETROS
                if(line.length==2)
                    ruta1 = line[1];

                if(line.length==3) {
                    ruta2 = line[2];
                    ruta1 = line[1] + " " + line[2];
                }


            switch (cmd) {
                case "pwd" -> System.out.println(MiniFileManager.getPathCarpetaActual());

                case "cd" -> {
                    try {
                        MiniFileManager.cambiarCarpeta(ruta1);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case "ls" -> MiniFileManager.listaContenido();

                case "ll" -> MiniFileManager.listaContenidoInfo();

                case "mkdir" -> {

                    try {
                        System.out.println(MiniFileManager.crearCarpeta(ruta1) ?
                                "Carpeta creada con exito" :
                                "Carpeta no creada"
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case "rm" -> {
                    try {
                        System.out.println(MiniFileManager.borrar(new File(ruta1)) ?
                                "Borrado con exito" :
                                "Borrado incompleto"
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case "mv" -> {
                    try {
                        System.out.println(MiniFileManager.mover(new File(ruta1), new File(ruta2)) ?
                                "Borrado con exito" :
                                "Borrado incompleto"
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case "help" -> System.out.print("""
                        Lista de comandos:
                        • pwd:                   Muestra cual es la carpeta actual.
                        • cd <DIR>:              Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.
                        • ls:                    Muestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego archivos, ambos ordenados alfabéticamente).
                        • ll:                    Como ls pero muestra también el tamaño y la fecha de última modificación.
                        • mkdir <DIR>:           Crea el directorio ‘DIR’ en la carpeta actual.
                        • rm <FILE>:             Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.
                        • mv <FILE1> <FILE2>:    Mueve o renombra ‘FILE1’ a ‘FILE2’.
                        • help:                  Muestra una breve ayuda con los comandos disponibles.
                        • exit:                  Termina el programa.
                        """);

                case "exit" -> repeat = false;

                default -> System.out.printf("'%s' no es reconocido como un comando", cmd);
            }

        } while (repeat);
    }
}
