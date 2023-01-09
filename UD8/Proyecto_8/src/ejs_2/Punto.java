package ejs_2;

import java.util.concurrent.ThreadLocalRandom;

public class Punto {
    private int x, y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void imprime() {
        System.out.println("(" + this.x + "," + this.y + ")");
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    public void desplaza(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }


    public static Punto creaPuntoAleatorio() {
        return new Punto(
                ThreadLocalRandom.current().nextInt(-100, 101),
                ThreadLocalRandom.current().nextInt(-100, 101)
        );
    }
}


