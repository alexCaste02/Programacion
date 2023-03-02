package maraton.e_01;

public class Triangulo extends Figura2D{

    public String estilo;

    public double area(){
        return ancho*alto/2;
    }

    public void verEstilo(){
        System.out.printf("Estilo: %s \n",estilo);
    }


}
