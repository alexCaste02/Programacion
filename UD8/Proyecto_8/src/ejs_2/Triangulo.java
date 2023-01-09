package ejs_2;

public class Triangulo {

    private Punto p1,p2,p3;

    public Triangulo(Punto p1, Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double perimetro(){
        return p1.distancia(p2)+p2.distancia(p3)+p3.distancia(p1);
    }
}
