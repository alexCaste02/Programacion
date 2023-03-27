package e_10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Persona_v3 implements Comparable<Persona_v3> {

    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona_v3(String nombre, String telefono, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad(){
        return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona_v3 personaV3 = (Persona_v3) o;
        return Objects.equals(nombre, personaV3.nombre) && Objects.equals(telefono, personaV3.telefono) && Objects.equals(email, personaV3.email) && Objects.equals(fechaNacimiento, personaV3.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, email, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                "}\n";
    }

    @Override
    public int compareTo(Persona_v3 p2) {
        return this.nombre.compareToIgnoreCase(p2.nombre);
    }


}
