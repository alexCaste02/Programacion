package e_B.e_B2;

public class Alumno {
    private String nombre;
    private String apellido;
    private double media;

    public Alumno(String nombre, String apellido, double media) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.media = media;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return String.format("Alumno: %s -- Media: %.2f",nombre+" "+apellido,media);
    }
}
