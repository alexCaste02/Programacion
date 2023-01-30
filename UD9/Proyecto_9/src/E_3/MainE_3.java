/*
Ejercicio 3 - Productos
Supongamos una clase Producto con dos atributos:
• String nombre
• int cantidad
Implementa esta clase con un constructor (con parámetros) además de los getters y
setters de sus dos atributos. No es necesario comprobar los datos introducidos.
A continuación, en el programa principal haz lo siguiente:
1. Crea 5 instancias de la Clase Producto.
2. Crea un ArrayList.
3. Añade las 5 instancias de Producto al ArrayList.
4. Visualiza el contenido de ArrayList utilizando Iterator.
5. Elimina dos elemento del ArrayList.
6. Inserta un nuevo objeto producto en medio de la lista.
7. Visualiza de nuevo el contenido de ArrayList utilizando Iterator.
8. Elimina todos los valores del ArrayList.
*/

package E_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainE_3 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //1
        Productos p1 = new Productos("Agua",1);
        Productos p2 = new Productos("Chuletas",10);
        Productos p3 = new Productos("Camisa",15);
        Productos p4 = new Productos("Fruta",2);
        Productos p5 = new Productos("Pilas",33);

        //2
        ArrayList<Productos> listaProductos = new ArrayList<>();

        //3
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);

        //4
        Iterator<Productos> iter = listaProductos.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println();

        //5
        listaProductos.remove(3);
        listaProductos.remove(1);

        //6
        listaProductos.add(1,new Productos("Juguetes",3));

        //7
        iter = listaProductos.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        //8
        listaProductos.clear();

    }


}
