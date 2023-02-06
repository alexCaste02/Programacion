package ejs_1D;

/* 
Crea un programa con una clase llamada Rectangulo que representará un rectángulo
mediante dos coordenadas (x1,y1) y (x2,y2) en un plano, por lo que la clase deberá tener
cuatro atributos enteros: x1, y1, x2, y2.
*/

public class Rectangulo {
    private int x1, y1, x2, y2;

    public Rectangulo(int x1,int y1,int x2,int y2) {

        if (x1<x2 && y1<y2){
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
        if(x1<x2)
            this.x1 = x1;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setY1(int y1) {
        if(y1<y2)
            this.y1 = y1;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setX2(int x2) {
        if(x1<x2)
            this.x2 = x2;
        else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setY2(int y2) {
        if(y1<y2)
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
        if(x1<x2 && y1<y2) {
            this.x1 = x1;
            this.y1 = y1;
        }else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setX2Y2(int x2, int y2){
        if(x1<x2 && y1<y2) {
            this.x2 = x2;
            this.y2 = y2;
        }else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public void setAll(int x1, int y1, int x2, int y2){
        if(x1<x2 && y1<y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }else
            System.err.println("ERROR al instanciar Rectangulo...");
    }

    public int getPerimetro(){
        return ((x2-x1)*2+(y2-y1)*2);
    }

    public int getArea(){
        return ((x2-x1)*(y2-y1));
    }
}
