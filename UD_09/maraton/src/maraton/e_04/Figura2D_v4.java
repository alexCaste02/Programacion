package maraton.e_04;

public class Figura2D_v4 {

    private double ancho;
    private double alto;

    public Figura2D_v4(double alto, double ancho){
        this.alto = alto;
        this.ancho = ancho;
    }


    public void verDim(){
        System.out.printf("Alto: %.2f, Ancho: %.2f \n",alto,ancho);
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
}
