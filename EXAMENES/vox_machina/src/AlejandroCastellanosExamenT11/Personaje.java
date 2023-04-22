package AlejandroCastellanosExamenT11;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Personaje implements Comparable<Personaje>{

    private final String nombre;
    protected int fuerza;
    private boolean herido=false,muerto=false;

    public static final int FUERZA_PORDEFECTO=5;

    public Personaje(String nombre) {
        this.nombre=nombre;
    }

    abstract public boolean retirarse() throws Exception;

    /**
     * Comrprueba si un valor es correcto para el atributo fuerza >=1 y <=10
     * @param f fuerza a establecer
     * @return
     */
    public static boolean comprobarFuerza(int f) {
        return f<=10 && f>=1;
    }
    /**
     * Establece un valor aleatorio para el atributo fuerza
     */
    protected void setFuerzaAleatoria() {
        this.fuerza=ThreadLocalRandom.current().nextInt(1, 11);
    }

    // Getters y Setters
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public boolean isHerido() {
        return herido;
    }
    public void setHerido(boolean herido) {

        if(muerto)
            this.herido = false;
        else
            this.herido = herido;

    }
    public boolean isMuerto() {
        return muerto;
    }
    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
        if(muerto) setHerido(false);

        //herido=verdadero y pasar muerto a verdadero
//        if(this.herido && muerto){
//            this.muerto=true;
//            this.herido=false;
//
//        } else if (this.herido && !muerto) {
//            this.muerto=false;
//            this.herido=true;
//
//        } else if (!this.herido && muerto) {
//            this.muerto=true;
//            this.herido=false;
//
//        } else if (!this.herido && !muerto) {
//            this.muerto=false;
//            this.herido=false;
//
//        }

    }
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return - String formateado de forma lineal que contiene los atributos del objeto
     */
    @Override
    public String toString() {
        return String.format("%-10s - %-6s - %-6s - %-6s",nombre,fuerza,herido,muerto);
    }

    /**
     * Comprueba si son iguales este (this) objeto a otra objeto segun atributo nombre
     * @param o - Objeto a comparar
     * @return - Si se trata de un objeto clase Personaje con el atributo nombre identico
     * devuelve 'true', en caso contrario 'false'
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre);
    }

    /**
     * Genera hash a partir del atributo nombre
     * @return - hash (int)
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Compara dos personajes segun su atributo 'nombre'
     * Implementa la ordenacion natural de esta clase
     * @param o the object to be compared.
     * @return - un entero
     * si int<0 entonces this.personaje va "antes" o es "menor"
     * si int>0 entonces this.personaje va "despues" o es "mayor"
     * si int=0 ambos son considerados iguales
     */
    @Override
    public int compareTo(Personaje o) {
        return this.nombre.compareTo(o.nombre);
    }
}



