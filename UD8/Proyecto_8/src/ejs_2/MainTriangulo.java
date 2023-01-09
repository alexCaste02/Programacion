package ejs_2;

public class MainTriangulo {
    public static void main(String[] args) {

        //    Triangulo tri1 = new Triangulo(new Punto());

        Punto p1 = new Punto(0,0);
        Punto p2 = new Punto(4,0);
        Punto p3 = new Punto(2,2);

        Triangulo tri1 = new Triangulo(p1,p2,p3);

        System.out.printf("El perimetro del triangulo es: %.3f",tri1.perimetro());

    }
}
