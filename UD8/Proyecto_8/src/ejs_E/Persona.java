package ejs_E;

/* 
Crea un programa con una clase llamada Persona que representará los datos principales
de una persona: dni, nombre, apellidos y edad.
*/

public class Persona {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        return (edad >= 18);
    }

    public boolean esJubilado(){
        return (edad >= 65);
    }

    public int diferenciaEdad(Persona p){
        return Math.abs(p.edad-this.edad);
    }
}
