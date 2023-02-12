package ex_Guiado;

import java.util.Objects;

public abstract class Animal {

    private final String nombre;
    private int estancia;

    public Animal(String nombre, int estancia) {
        this.nombre = nombre;
        this.estancia = estancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstancia() {
        return estancia;
    }

    public void setEstancia(int estancia) {
        this.estancia = estancia;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (!(obj instanceof Animal))
//            return false;
//        return this.nombre.equals(((Animal)obj).nombre);
//    }

    //He usado el generador en lugar del ejemplo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //TODO: aqui se puede usar animal como variable porque se "crea" en el instanceof?
        if (!(o instanceof Animal animal)) return false;
        return estancia == animal.estancia && Objects.equals(nombre, animal.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, estancia);
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", Estancia=" + estancia;
    }

    public abstract void ejercicio();


}
