/*

Ejercicio 4 – Factura
Diseñar una clase Factura que consta de:
• Número identificador: lo proporciona el usuario en el alta de la factura.
• Fecha de la factura: la toma del sistema en el momento del alta.
• Número de cliente: : lo proporciona el usuario en el alta de la factura.
• Porcentaje de IVA: 21% para todas las facturas.
• Un número indeterminado de lineaFactura que contienen:

    ◦ Descripción del producto
    ◦ Precio unitario
    ◦ Cantidad de unidades
    ◦ Porcentaje de descuento: 5% para líneas con más de 10 unidades.
    ◦ Importe total de la línea.

• Importe total: inicialmente cero, y se va actualizando siempre que se
añadan/eliminen líneas.

Implementar la clase con su constructor y métodos para añadir línea de factura, eliminar
línea de factura y mostrar la factura por consola. Te hará falta una clase LineaFactura con
su constructor. Para añadir línea de factura, habrá que solicitar al usuario los campos
necesarios para añadirlo (descripción, precio unitario y cantidad de unidades). Para
eliminar una línea, solicitaremos el número de línea.
Hacer también un programa con un menú para gestionar una factura (alta,
añadir/eliminar líneas, mostrar factura) Nota: pensar en método toString() para
LíneaFactura.

*/

package E_04;


import java.util.ArrayList;
import java.util.Scanner;

public class MainE_4 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Factura> listaFactura = new ArrayList<>();
//        while(menu());

    }
    public static boolean menu(ArrayList<Factura> lista){

        System.out.print("""
                Selecciona la accion que quieres realizar:
                
                1) Alta
                2) Añadir linea
                3) Eliminar linea
                4) Mostrar Factura
                
                0) Salir
                
                """);


        switch (readAndValidateOption()){

            case 1 -> alta(lista);
            case 2 -> addLinea(lista);
            case 3 -> removeLinea(lista);
            case 4 -> mostrar(lista);
            case 0 -> {return false;}


        }

        return true;
    }

    public static int readAndValidateOption(){
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.matches("[0-4]"))
                return Integer.parseInt(inputLine);

            System.out.println("El numero introducido no es una opcion valida, vuelve a intentarlo");
        }
    }

    public static void alta(ArrayList<Factura> lista) {
        System.out.println("Introduce num cliente");
        lista.add(new Factura(lista.size(),input.nextLine()));
    }

    public static void addLinea(ArrayList<Factura> lista){

    }

    public static void removeLinea(ArrayList<Factura> lista){

    }

    public static void mostrar(ArrayList<Factura> lista){

    }




}
