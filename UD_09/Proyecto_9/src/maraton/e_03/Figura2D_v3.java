package maraton.e_03;

public class Figura2D_v3 {

    private double ancho;
    private double alto;

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
