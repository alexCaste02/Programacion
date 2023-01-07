package ejs_E;

/*
En el main de la clase principal instancia 3 objetos Punto con las coordenadas (5,0),
(10,10) y (-3, 7). Muestra por pantalla sus coordenadas (utiliza un println para cada
punto). Modifica todas las coordenadas (prueba distintos operadores como = + - +=
*=...) y vuelve a imprimirlas por pantalla.
*/

public class MainPunto {
    public static void main(String[] args) {

//        Punto punto1 = new Punto(5,0);
//        Punto punto2 = new Punto(10,10);
//        Punto punto3 = new Punto(3,7);
//
//
//        System.out.println(punto1.getX()+","+punto1.getY());
//        System.out.println(punto2.getX()+","+punto2.getY());
//        System.out.println(punto3.getX()+","+punto3.getY());
//
//
//        punto1.setX(punto1.getX()+1);
//        punto1.setY(punto1.getY()-2);
//
//        punto2.setX(punto1.getX()*3);
//        punto2.setY(punto1.getY()/4);
//
//        punto3.setX(punto1.getX()+5);
//        punto3.setY(punto1.getY()-6);
//
//
//
//        System.out.println(punto1.getX()+","+punto1.getY());
//        System.out.println(punto2.getX()+","+punto2.getY());
//        System.out.println(punto3.getX()+","+punto3.getY());
//
//
//        punto1.imprime();
//        punto1.setXY(2,5);
//        punto1.desplaza(1,1);
//        punto1.imprime();
//        punto2.imprime();
//        System.out.println(punto1.distancia(punto2));

        Punto p1 = Punto.creaPuntoAleatorio();
        p1.imprime();

        Punto p2 = Punto.creaPuntoAleatorio();
        p2.imprime();

        Punto p3 = Punto.creaPuntoAleatorio();
        p3.imprime();

    }
}
