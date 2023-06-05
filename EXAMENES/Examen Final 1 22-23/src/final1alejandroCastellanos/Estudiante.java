package final1alejandroCastellanos;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Estudiante implements Serializable {

    @Serial
    private static final long serialVersionUID = 2223L;

    private final String identificador;
    private String nombre;
    private String apellidos;
    private String correo;
    private Map<Asignatura, Double> asignaturas;

    public Estudiante(String identificador, String nombre, String apellidos, String correo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.asignaturas = new HashMap<>();
    }

    /**
     * Generamos un pin de una longitud 1-10 formado por numeros no repetidos
     * @param num Longitud del pin
     * @return pin guardado en tipo Long
     */
    public long obtenerPin(int num) {
        if (num > 10 || num < 0) num = 10;

        StringBuilder numerosLibres = new StringBuilder("0123456789");
        StringBuilder cadenaPin = new StringBuilder();

        // Vamos añadiendo numeros a una cadena nueva segun un numero aleatorio que determina la posicion en la cadena
        //de numeros posibles.
        //  Luego eliminamos el numero de dicha cadena para evitar repeticiones
        for (int i = 0; i < num; i++) {
            int posicionNum = ThreadLocalRandom.current().nextInt(0, numerosLibres.length());
            cadenaPin.append(numerosLibres.charAt(posicionNum));
            numerosLibres.deleteCharAt(posicionNum);
        }

        return Long.parseLong(cadenaPin.toString());
    }

    /**
     * Generamos un pin de longitud 4 formado por numeros no repetidos
     * @return pin guardado en tipo Long
     */
    public long obtenerPin(){
        return obtenerPin(4);
    }

    /**
     * Genera un login formado por los 3 primeros caracteres del nombre + 3 primeros del apellido.
     * De no ser posible, se toman los caracteres que se pueda
     * @return pin guardado en tipo Long
     */
    public String obtenerLogin(){
        String login;
        //Separamos para solo obtener el primer apelliddo
        String[] apellidosArray = apellidos.split(" ");
        String primerApellido = apellidosArray[1];

        if(nombre.length()<3) login = nombre;
        else login = nombre.substring(0,3);

        if(primerApellido.length()<3) login += primerApellido;
        else login += primerApellido.substring(0,3);

        return login.toLowerCase();
    }

    /**
     * Comprueba si el atributo correo tiene formato valido
     * @return True si el correo esta bien formateado
     */
    public boolean esCorreoValido(){
        return correo.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }

    /**
     * Añade a un alumno al Mapa de Asignatura-Notas (llamado asignaturas) a partir de un objeto Asignatura
     * @param asignatura Asignatura en al que se matricula (crea entrada en el mapa)
     */
    public void matricular(Asignatura asignatura){
        asignaturas.put(asignatura,0.0);
    }

    /**
     * Cambia la nota almacenada en el mapa de asignaturas a partir de un codigo de asignatura
     * @param codigoBuscado Codigo de la asignatura a cambiar
     * @param nota Nota nueva
     * @throws Exception Lanzada si no existe una Asignatura con ese codigo en el mapa
     */
    public void cambiarNota(int codigoBuscado, double nota) throws Exception {
        //Recorremos las asignaturas guardadas hasta encontrar una que tenga el codigo que buscamos
        for (Asignatura asignatura : asignaturas.keySet()) {
            if(asignatura.codigo==codigoBuscado){
                asignaturas.put(asignatura,nota);
                return;
            }
        }

        //Si no encontramos una asignatura, lanzamos error con este mensaje
        throw new Exception("No se ha encontrado una asignatura con ese codigo");
    }

    /**
     *  Cambia la nota almacenada en el mapa de asignaturas a partir de un nombre de asignatura
     * @param nombreBuscado Nombre de la asignatura a cambiar
     * @param nota Nota nueva
     * @throws Exception Lanzada si no existe una Asignatura con ese codigo en el mapa
     */
    public void cambiarNota(String nombreBuscado, double nota) throws Exception {
        //Igual que el anterior metodo pero a partir del nombre
        for (Asignatura asignatura : asignaturas.keySet()) {
            if(asignatura.nombre.equals(nombreBuscado)){
                asignaturas.put(asignatura,nota);
                return;
            }
        }

        throw new Exception("No se ha encontrado una asignatura con ese codigo");
    }

    /**
     * Comprueba si un alumno promociona o no
     * @return True si nota>5 en todas las entradas del mapa
     */
    public boolean promociona(){
        for (Double nota : asignaturas.values()) {
            if(nota<5)
                return false;
        }
        return true;
    }

    //TODO: Usar stream
    /**
     * Muestra todas las entradas del mapa 'asignaturas' del estudiante
     */
    public void mostrarNotas(){
        ArrayList<Map.Entry<Asignatura,Double>> listAsignaturas = new ArrayList<>(asignaturas.entrySet());

        listAsignaturas.sort(new Comparator<Map.Entry<Asignatura, Double>>() {
            @Override
            public int compare(Map.Entry<Asignatura, Double> o1, Map.Entry<Asignatura, Double> o2) {
                return o1.getKey().nombre.compareTo(o2.getKey().nombre);
            }
        });

        //Puede ser simplificado a esto, ya que podemos obtener la clave de comparacion
        //listAsignaturas.sort(Comparator.comparing(entry -> entry.getKey().nombre));

        System.out.printf("%10s:%-35s::%4s",
                "Codigo", "Nombre de Asignatura", "Nota"
        );

        for (Map.Entry<Asignatura, Double> entry : listAsignaturas) {
            System.out.printf("%n%10d:%-35s::%.2f",
                    entry.getKey().codigo, entry.getKey().nombre, entry.getValue()
            );
        }
    }

    public Map<Asignatura, Double> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public String toString() {
        return String.format("%-15s - %-15s - %-25s - %-30s",
                identificador, nombre, apellidos, correo
        );
    }
}
