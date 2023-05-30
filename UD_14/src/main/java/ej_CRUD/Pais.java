package ej_CRUD;

import java.util.List;

public class Pais {
    private String codigo;
    private String nombre;
    private List<Ciudad> ciudades;

    public Pais(String codigo, String nombre, List<Ciudad> ciudades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudades = ciudades;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
