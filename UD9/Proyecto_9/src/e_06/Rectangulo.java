package e_06;

public class Rectangulo implements Figura2D{

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    double ancho;
    double alto;

    @Override
    public double perimetro() {
        return alto*2+ancho*2;
    }

    @Override
    public double area() {
        return ancho*alto;
    }

    @Override
    public void escalar(double escala) {
        this.ancho = ancho*escala;
        this.alto = alto*escala;
    }

    @Override
    public void imprimir() {
        System.out.println("Rectangulo de anchura "+ancho+" y de altura "+alto);
    }
}
