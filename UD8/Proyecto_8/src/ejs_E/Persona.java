package ejs_E;

/* 
Crea un programa con una clase llamada Persona que representará los datos principales
de una persona: dni, nombre, apellidos y edad.
*/

public class Persona {
    private final String dni;
    //no puedo mostrar error y declararlo como final (no inicializado)
    private String nombre;
    private String apellidos;
    private int edad;

    private static final int mayoriaEdad = 18;

    public Persona(String dni, String nombre, String apellidos, int edad) {
        if (validarDNI(dni)){
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.edad = edad;
        } else {
            System.err.println("ERROR al instanciar");
            this.dni = null;
            //no puedo mostrar error y declararlo como final (no inicializado)
        }
    }

    public String getDni() {
        return dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public void imprime(){
        System.out.printf("""
                DNI: %s
                Nombre: %s
                Apellidos: %s
                Edad: %d
                """,dni,nombre,apellidos,edad);
    }

    public boolean esMayorEdad(){
        return (edad >= mayoriaEdad);
    }

    public boolean esJubilado(){
        return (edad >= 65);
    }

    public int diferenciaEdad(Persona p){
        return Math.abs(p.edad-this.edad);
    }


    public static boolean validarDNI(String DNI){
        return (DNI.matches("\\d{8}[a-zA-Z]"));
    }
}
