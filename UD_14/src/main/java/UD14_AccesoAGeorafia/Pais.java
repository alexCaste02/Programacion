package UD14_AccesoAGeorafia;

import java.util.Objects;

public class Pais {
    private String codigo;
    private String nombre;
    private String continente;
    private double superficie;
    private int poblacion;

    public Pais(String codigo, String nombre, String continente, double superficie, int poblacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.superficie = superficie;
        this.poblacion = poblacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(codigo, pais.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return String.format("%-50s - %-6s - %-15s - %-15.2f - %-15d",
                nombre,codigo,continente,superficie,poblacion
        );
    }
}
