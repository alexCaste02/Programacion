package ejs_C;

/*
Crea un programa con una clase llamada Articulo con los siguientes atributos: nombre,
precio (sin IVA), iva (siempre será 21) y cuantosQuedan (representa cuantos quedan en
el almacén).
 */

public class Articulo {
    private String nombre;
    private double precio;
    private int IVA;
    private int cuantosQuedan;

    public Articulo(String nombre, double precio, int IVA, int cuantosQuedan) {

        if (IVA==21 && precio>0 && cuantosQuedan>0){
            this.nombre = nombre;
            this.precio = precio;
            this.IVA = IVA;
            this.cuantosQuedan = cuantosQuedan;
        } else {
            System.err.println("ERROR al instanciar Articulo...");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        this.cuantosQuedan = cuantosQuedan;
    }
}
