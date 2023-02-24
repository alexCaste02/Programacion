package maraton.e_05;

public class Triangulo_v5 extends Figura2D_v5 {

    public String estilo;

    public Triangulo_v5(String estilo, double alto, double ancho) {
        super(alto, ancho);
        this.estilo = estilo;
    }

    public double area(){
        return getAncho()*getAlto()/2;
    }

    public void verEstilo(){
        System.out.printf("Estilo: %s \n",estilo);
    }


}
