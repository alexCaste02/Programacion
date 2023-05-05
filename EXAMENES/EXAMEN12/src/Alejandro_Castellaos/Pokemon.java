package Alejandro_Castellaos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pokemon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String tipo;
    private int salud;
    private int nivel;

    /**
     * Constructor de pokemons
     * @param nombre - Nombre del pokemon (String)
     * @param nivel - Nivel del pokemon (int)
     * @param salud - Salud del pokemon (int)
     * @param tipo - Tipo del pokemon (String)
     */
    public Pokemon(String nombre, int nivel, int salud, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.nivel = nivel;
    }


    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }


    // EQUALS Y HASHCODE (PARA UTILIZAR CONJUNTOS)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return getSalud() == pokemon.getSalud() && getNivel() == pokemon.getNivel() && Objects.equals(getNombre(), pokemon.getNombre()) && Objects.equals(getTipo(), pokemon.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getTipo(), getSalud(), getNivel());
    }


    // TO STRING
    @Override
    public String toString() {
        return "Alejandro_Castellaos.Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", salud=" + salud +
                ", nivel=" + nivel +
                "}\n";
    }
}
