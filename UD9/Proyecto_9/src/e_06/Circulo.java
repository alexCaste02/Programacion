package e_06;

public class Circulo implements Figura2D {

    public Circulo(double radio) {
        this.radio = radio;
    }

    double radio;

    @Override
    public double perimetro() {
        return 2*Math.PI*radio;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radio,2);
    }

    @Override
    public void escalar(double escala) {
        this.radio = radio*escala;
    }

    @Override
    public void imprimir() {
        System.out.println("Circulo de radio "+radio);
    }
}
