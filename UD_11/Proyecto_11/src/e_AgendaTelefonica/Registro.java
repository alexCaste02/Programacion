package e_AgendaTelefonica;

import java.util.Objects;

public record Registro(String nombre, String telefono){

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return Objects.equals(nombre, registro.nombre) && Objects.equals(telefono, registro.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Telefono: "+telefono;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String telefono() {
        return telefono;
    }
}
