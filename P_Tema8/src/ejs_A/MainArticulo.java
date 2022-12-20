package ejs_A;

/*
En el main de la clase principal instancia un objeto de la clase artículo. Asígnale valores a
todos sus atributos (los que quieras) y muestra por pantalla un mensaje del estilo
“Pijama - Precio:10€ - IVA:21% - PVP:12,1€” (el PVP es el precio de venta al público, es
decir, el precio con IVA). Luego, cambia el precio y vuelve a imprimir el mensaje.
 */

public class MainArticulo {
    public static void main(String[] args) {

        Articulo art = new Articulo();
        art.nombre = "Cereales";
        art.precio = 4.30;
        art.cuantosQuedan = 12;

        System.out.printf("%s - Precio: %.2f - IVA: %d - PVP: %.2f %n",art.nombre,art.precio,art.IVA,art.precio+art.precio*art.IVA/100);


        art.precio = 2.15;

        System.out.printf("%s - Precio: %.2f - IVA: %d - PVP: %.2f",art.nombre,art.precio,art.IVA,art.precio+art.precio*art.IVA/100);

    }


}
