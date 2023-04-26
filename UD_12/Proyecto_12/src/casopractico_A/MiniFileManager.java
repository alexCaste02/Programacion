package casopractico_A;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class MiniFileManager {

    private static File carpetaActual = new File("C:/");

    public static String getPathCarpetaActual(){
        return carpetaActual.getAbsolutePath();
    }

    public static void cambiarCarpeta(String dir) throws FileNotFoundException {
        File newfile;

        if(dir.equals("..")) newfile = carpetaActual.getParentFile();
        else if(dir.matches("[C:/].*") || dir.matches("[C:\\ ].*")) newfile = new File(dir);
        else newfile = new File(getPathCarpetaActual() + "/" + dir);

        if(!newfile.exists()) throw new FileNotFoundException("No se puede encontrar ruta especificada");
        carpetaActual = newfile;
    }
    
    public static void listaContenido(){
        Arrays.stream(Objects.requireNonNull(carpetaActual.listFiles()))
                .sorted((o1, o2) -> {
                    if (o1.isDirectory() && o2.isFile()) return -1;
                    else if (o1.isFile() && o2.isDirectory()) return 1;
                    return o1.getName().compareTo(o2.getName());
                }
        ).forEach(f -> System.out.println((f.isFile()?"[A] ":"[*] ")+f.getName()));
    }

    public static void listaContenidoInfo(){
        Arrays.stream(Objects.requireNonNull(carpetaActual.listFiles()))
                .sorted((o1, o2) -> {
                            if (o1.isDirectory() && o2.isFile()) return -1;
                            else if (o1.isFile() && o2.isDirectory()) return 1;
                            return o1.getName().compareTo(o2.getName());
                        })
                .forEach(f -> System.out.printf(
                            (f.isFile()?"[A] ":"[*] ")
                            +"%-40s - %8s bytes -      Ultima modificacion: %-15s\n",
                            f.getName(),f.length(),new Date(f.lastModified())
                        )
                );
    }

    public static boolean crearCarpeta(String dir){
        File newDir = new File(getPathCarpetaActual()+dir);
        return newDir.mkdir();
    }

    public static boolean borrar(File f) throws Exception {
        if(!f.exists()) throw new FileNotFoundException("La ruta no existe");

        if(f.isFile()) {
            System.out.println("Borrando archivo "+f.getName());
        } else {
            System.out.println("Borrando contenido de "+f.getPath());
            File[] contenido = f.listFiles();
            assert contenido != null;
            int size = contenido.length;
            int n = 1;

            for (File file : contenido) {
                if (file.isFile()) {
                    System.out.printf(
                            (file.delete() ?
                                    "Archivo borrado correctamente " :
                                    "Archivo no ha podido ser borrado ")
                                    + "[%s] (%d/%d)%n", file.getName(), n, size);
                } else {
                    throw new Exception("[AVISO] Esta carpeta contiene subcarpetas. Borrado detenido");
                }
                n++;
            }
            System.out.println("Borrando directorio...");
        }

        return f.delete();
    }

    public static boolean mover(File f1, File f2) throws FileNotFoundException {
        if(!f1.exists()) throw new FileNotFoundException("La primera ruta no existe");
        if(!f2.exists()) throw new FileNotFoundException("La segunda ruta no existe");

        return f1.renameTo(f2);
    }
}
