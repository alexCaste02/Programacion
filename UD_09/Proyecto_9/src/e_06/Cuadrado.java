package e_06;

public class Cuadrado implements Figura2D{

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    double lado;

    @Override
    public double perimetro() {
        return lado*4;
    }

    @Override
    public double area() {
        return lado*lado;
    }

    @Override
    public void escalar(double escala) {
        this.lado = lado*escala;
    }

    @Override
    public void imprimir() {
        System.out.println("Cuadrado de lado "+lado);
    }
}
