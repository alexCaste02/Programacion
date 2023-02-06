package ejs_1B;

/* 
Crea un programa con una clase llamada Persona que representará los datos principales
de una persona: dni, nombre, apellidos y edad.
*/

public class Persona {
    String dni;
    String nombre;
    String apellidos;
    int edad;

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
}
