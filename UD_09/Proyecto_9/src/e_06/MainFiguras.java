package e_06;

import java.util.ArrayList;

public class MainFiguras {
    public static void main(String[] args) {

        ArrayList<Figura2D> listaFiguras = new ArrayList<>();

        listaFiguras.add(new Cuadrado(5));
        listaFiguras.add(new Rectangulo(3,2));
        listaFiguras.add(new Triangulo(10,10));
        listaFiguras.add(new Circulo(3.3));

        for (Figura2D figura : listaFiguras) {
            figura.imprimir();
        }


        for (Figura2D figura : listaFiguras) {
            figura.escalar(2);
        }

        for (Figura2D figura : listaFiguras) {
            figura.imprimir();
        }


        for (Figura2D figura : listaFiguras) {
            figura.escalar(0.1);
        }

        for (Figura2D figura : listaFiguras) {
            figura.imprimir();
        }

    }
}
