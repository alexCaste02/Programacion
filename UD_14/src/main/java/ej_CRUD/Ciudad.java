package ej_CRUD;

public class Ciudad {

    private String id;
    private String nombre;
    private String distrito;
    private int poblacion;

    private String codigoPais;

    public Ciudad(String id, String nombre, String distrito, int poblacion, String codigoPais) {
        this.id = id;
        this.nombre = nombre;
        this.distrito = distrito;
        this.poblacion = poblacion;
        this.codigoPais = codigoPais;
    }

    public Ciudad(String nombre, String distrito, int poblacion, String codigoPais) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.poblacion = poblacion;
        this.codigoPais = codigoPais;
    }

    public Ciudad(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }
}
