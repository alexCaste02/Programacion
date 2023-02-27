package e_06;

public class Gato {

    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws Exception {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length()>=3)
            this.nombre = nombre;
        else
            throw new Exception("Nombre demasiado corto");
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        if(edad>=0)
            this.edad = edad;
        else
            throw new Exception("Edad no puede ser negativa");

    }

    public void imprimir(){
        System.out.printf("""
                Nombre: %s
                Edad: %d
                """,nombre,edad);
    }
}
