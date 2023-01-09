package ejs_1E;

/* 
Crea un programa con una clase llamada Rectangulo que representará un rectángulo
mediante dos coordenadas (x1,y1) y (x2,y2) en un plano, por lo que la clase deberá tener
cuatro atributos enteros: x1, y1, x2, y2.
*/

import java.util.concurrent.ThreadLocalRandom;

public class Rectangulo {
    private int x1, y1, x2, y2;
    private static final int min = 0, max = 100;



    public Rectangulo(int x1,int y1,int x2,int y2) {

        if (x1<x2 && y1<y2 && x1>=min && y1>=min && x2<=max && y2<=max){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        } else {
            System.err.println("ERROR al instanciar Rectangulo...");
        }

    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        if(x1<x2 && x1>=min)
            this.x1 = x1;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setY1(int y1) {
        if(y1<y2 && y1>=min)
            this.y1 = y1;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setX2(int x2) {
        if(x1<x2 && x2<=max)
            this.x2 = x2;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setY2(int y2) {
        if(y1<y2 && y2<=max)
            this.y2 = y2;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }


    public void imprime(){
        System.out.printf("""
                Punto inferior izquierdo: (x=%d,y=%d)
                Punto superior derecho: (x=%d,y=%d)
                """,x1,y1,x2,y2);
    }

    public void setX1Y1(int x1, int y1){
        setX1(x1);
        setY1(y1);
    }

    public void setX2Y2(int x2, int y2){
        setX2(x2);
        setY2(y2);
    }

    public void setAll(int x1, int y1, int x2, int y2){
        setX1Y1(x1,y1);
        setX2Y2(x2,y2);
    }

    public int getPerimetro(){
        return ((x2-x1)*2+(y2-y1)*2);
    }

    public int getArea(){
        return ((x2-x1)*(y2-y1));
    }

    public static Rectangulo creaRectanguloAleatorio() {

        int x1 = ThreadLocalRandom.current().nextInt(0, 100);
        int y1 = ThreadLocalRandom.current().nextInt(0, 100);
        int x2 = ThreadLocalRandom.current().nextInt(x1+1, 101);
        int y2 = ThreadLocalRandom.current().nextInt(y1+1, 101);

        return new Rectangulo(x1,y1,x2,y2);

    }



}
