package maraton.e_03;

public class Triangulo_v3 extends Figura2D_v3 {

    public String estilo;

    public Triangulo_v3(String estilo, double alto, double ancho) {
        super();
        setAlto(alto);
        setAncho(ancho);
        this.estilo = estilo;
    }

    public double area(){
        return getAncho()*getAlto()/2;
    }

    public void verEstilo(){
        System.out.printf("Estilo: %s \n",estilo);
    }


}
