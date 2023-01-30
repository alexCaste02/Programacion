/*
Ejercicio 8 – La tienda del barrio
En La Tienda del Barrio S.A. necesitan un programa en lenguaje Java que les ayude a
gestionar la información sobre los artículos que tienen en la tienda, así como realizar
ventas a clientes y compras a proveedores.
Clase ‘Articulo’
• Un artículo tiene un identificador (número entero), un nombre, un precio de
venta a cliente, un precio de compra a proveedor, un IVA (%) y un stock
(representa la cantidad de ese artículo disponible en tienda). El nombre y el
identificador de un artículo no pueden cambiar. El identificador ha de establecerse
automáticamente y ser único, podemos llevar un contador de los objetos creados y
así el identificador será único. El IVA es el mismo para todos los artículos (un 21%).
Tanto el precio de compra como el precio de venta han de ser valores superiores a
cero. El precio de venta ha de ser superior al precio de compra. El stock ha de ser
superior o igual a cero.
• Deberá tener un único constructor así como todos los getters y setters que sea
posible.
• Deberá tener al menos dos métodos públicos, uno para vender (a cliente) y otro
para comprar (a proveedor). En ambos casos deberá pasarse un único argumento
con la cantidad de unidades a vender o comprar, y se devolverá un valor indicando
si fue posible realizar la operación o no. Si la operación se puede realizar, se
deberá modificar el stock del artículo.
• Deberá tener un método público que devuelva una cadena de texto de una sola
línea con la información sobre dicho artículo: id, nombre, precios, IVA y stock.
• En los casos en los que sea necesario, los métodos públicos mostrarán un
mensaje por System.err si no es posible realizar la operación solicitada.
• Pueden implementarse otros métodos si se considera necesario.
• Es obligatorio que esta clase no realice ningún tipo de entrada por teclado ni
salida por pantalla (Excepto los mencionados mensajes de error).
Clase ‘Tienda’
• Contendrá la función ‘main’ del programa.
• Al iniciar el programa se mostrará por pantalla un menú principal con las
siguientes opciones:
1. Mostrar artículos.
2. Venta a cliente.
3. Compra a proveedor.
4. Gestionar artículos.
5. Salir.
• La opción 1 mostrará por pantalla la descripción de todos los artículos de la
tienda.
• La opción 2 permitirá realizar una venta. Pedirá los identificadores y cantidades
de los artículos deseados además del nombre del cliente. Mostrará el precio total y
pedirá confirmar la venta.
• La opción 3 permitirá realizar una compra. Pedirá los identificadores y cantidades
de los artículos deseados además del nombre del proveedor. Mostrará el precio
total y pedirá confirmar la compra.
• La opción 4 mostrará un submenú con cuatro opciones: ‘1. Añadir artículo’, ‘2.
Editar artículo’, ‘3. Eliminar artículo’ y ‘4. Volver’. Las tres primeras opciones pedirán
introducir la información necesaria y realizarán la operación si es posible. La
cuarta opción volverá al menú principal.
• La opción 5 termina el programa.
•El menú principal y el submenú se volverán a mostrar tras cada operación hasta
que el usuario elija ‘Salir’ o ‘Volver’ según el caso.
• Toda interacción con el usuario deberá realizarse por entrada y salida estándar
(teclado y pantalla).
• Los artículos deberán almacenarse en memoria en alguna estructura de datos.
• Deberán manejarse los posibles errores y que puedan producirse.
• No programes toddo directamente en la función main. Implementa distintas
funciones adicionales para que el código sea lo más modular.
• Es obligatorio utilizar la clase ‘Articulo’.
 */

package E_8;

import java.util.ArrayList;

public class Articulo {

    private static ArrayList<Articulo> listaArticulos = new ArrayList<>();

    private static final int IVA = 21;

    private final int identificador = listaArticulos.size()+1;
    private final String nombre;

    private double precioVenta ;
    private double precioCompraProveedor ;
    private int stock;

    /*CONSTRUCTOR*/
    public Articulo(String nombre, double precioVenta, double precioCompraProveedor, int stock) {

        this.nombre = nombre;
        if (validatePrecioVenta(precioVenta) && validatePrecioCompraProveedor(precioCompraProveedor) && validateStock(stock)) {
            this.precioVenta = precioVenta;
            this.precioCompraProveedor = precioCompraProveedor;
            this.stock = stock;
        } else {
            System.err.println("Error de instanciacion. Todos los atributos asignados como nulos/0");
        }


    }

    /*G&S*/
    public int getIdentificador() {
        return identificador;
    }
    public String getNombre() {
        return nombre;
    }

    public static ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }
    public double getPrecioVenta() {
        return precioVenta;
    }
    public double getPrecioCompraProveedor() {
        return precioCompraProveedor;
    }
    public int getStock() {
        return stock;
    }

    public static void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        Articulo.listaArticulos = listaArticulos;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public void setPrecioCompraProveedor(double precioCompraProveedor) {
        this.precioCompraProveedor = precioCompraProveedor;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    /*INTERNAL VALIDATIONS*/
    public boolean validatePrecioCompraProveedor(double precio){
        return precio > 0;
    }

    public boolean validatePrecioVenta(double precio){
        return precio > 0 && precio > precioCompraProveedor;
    }

    public boolean validateStock(int stock){
        return stock>=0;
    }


    /*FUNCTIONAL METHODS*/
    public boolean vender(int cantidad){
        if(cantidad>0 && stock-cantidad>=0){
            stock-=cantidad;
            return true;
        }
        System.err.println("Error al realizar la venta al cliente");
        return false;
    }

    public boolean comprar(int cantidad){
        if(cantidad>0){
            stock+=cantidad;
            return true;
        }
        System.err.println("Error al realizar la compra al proveedor");
        return false;
    }

    public String infoArticulo(){
        return String.format("ID: %d, Nombre: %s, Precio de compra al proveedor: %.2f, Precio de venta al cliente: %.2f, IVA: %d, Stock: %d",identificador,nombre,precioCompraProveedor,precioVenta,IVA,stock);
    }

    public static Articulo findArticulo(int idArticulo){
        for (Articulo listaArticulo : listaArticulos) {
            if (listaArticulo.identificador == idArticulo)
                return listaArticulo;
        }
        return null;
    }

}
