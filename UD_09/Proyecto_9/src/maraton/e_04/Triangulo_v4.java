package maraton.e_04;

public class Triangulo_v4 extends Figura2D_v4 {

    public String estilo;

    public Triangulo_v4(String estilo, double alto, double ancho) {
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
