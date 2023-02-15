package e_06;

public class Triangulo implements Figura2D{

    public Triangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    double ancho;
    double alto;

    @Override
    public double perimetro() {
        return 69; //faltan datos para poder saber el perimetro?
    }

    @Override
    public double area() {
        return ancho*alto/2;
    }

    @Override
    public void escalar(double escala) {
        this.ancho = ancho*escala;
        this.alto = alto*escala;
    }

    @Override
    public void imprimir() {
        System.out.println("Triangulo de anchura "+ancho+" y de altura "+alto);
    }
}
