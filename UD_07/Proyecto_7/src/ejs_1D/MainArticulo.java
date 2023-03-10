package ejs_1D;

/*
En el main de la clase principal instancia un objeto de la clase artículo. Asígnale valores a
todos sus atributos (los que quieras) y muestra por pantalla un mensaje del estilo
“Pijama - Precio:10€ - IVA:21% - PVP:12,1€” (el PVP es el precio de venta al público, es
decir, el precio con IVA). Luego, cambia el precio y vuelve a imprimir el mensaje.
 */

public class MainArticulo {
    public static void main(String[] args) {

        Articulo art1 = new Articulo("Cereales",4.3,21,12);
        Articulo art2 = new Articulo("Arroz",-3,21,12);
        Articulo art3 = new Articulo("Leche",4.3,19,-1);

        art1.imprime();
        System.out.println(art1.getPVP());
        System.out.println(art1.getPVPDescuento(15));

        art1.setPrecio(2.15);
        art1.imprime();


        System.out.println("vender 5?"+art1.vender(5));
        art1.imprime();
        System.out.println("vender 50?"+art1.vender(50));
        art1.imprime();
        System.out.println("vender -5?"+art1.vender(-5));
        art1.imprime();

        System.out.println("almacenar 5?"+art1.almacenar(5));
        art1.imprime();
        System.out.println("almacenar -1?"+art1.almacenar(-1));
        art1.imprime();


    }


}
