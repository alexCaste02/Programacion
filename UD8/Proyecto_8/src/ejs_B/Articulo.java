package ejs_B;

/*
Crea un programa con una clase llamada Articulo con los siguientes atributos: nombre,
precio (sin IVA), iva (siempre será 21) y cuantosQuedan (representa cuantos quedan en
el almacén).
 */

public class Articulo {
    String nombre;
    double precio;
    int IVA;
    int cuantosQuedan;

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
}
