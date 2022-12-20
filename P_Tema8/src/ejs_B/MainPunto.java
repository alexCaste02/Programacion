package ejs_B;

/*
En el main de la clase principal instancia 3 objetos Punto con las coordenadas (5,0),
(10,10) y (-3, 7). Muestra por pantalla sus coordenadas (utiliza un println para cada
punto). Modifica todas las coordenadas (prueba distintos operadores como = + - +=
*=...) y vuelve a imprimirlas por pantalla.
*/

public class MainPunto {
    public static void main(String[] args) {

        Punto punto1 = new Punto(5,0);
        Punto punto2 = new Punto(10,10);
        Punto punto3 = new Punto(3,7);


        System.out.println(punto1.x);
        System.out.println(punto1.y);
        System.out.println(punto2.x);
        System.out.println(punto2.y);
        System.out.println(punto3.x);
        System.out.println(punto3.y);


        punto1.x+=1;
        punto1.y-=2;
        punto2.x*=3;
        punto2.y/=4;
        punto3.x++;
        punto3.y--;

        System.out.println(punto1.x);
        System.out.println(punto1.y);
        System.out.println(punto2.x);
        System.out.println(punto2.y);
        System.out.println(punto3.x);
        System.out.println(punto3.y);

    }
}
