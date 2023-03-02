package maraton.e_02;

public class Triangulo_v2 extends Figura2D_v2 {

    public String estilo;

    public double area(){
        return getAncho()*getAlto()/2;
    }

    public void verEstilo(){
        System.out.printf("Estilo: %s \n",estilo);
    }


}
