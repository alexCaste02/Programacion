package e_01;

public abstract class Astros {

    int masa;
    int diametro;
    int periodoRotacion;
    int periodoTranslacion;
    int distanciaMedia;

    public Astros(int masa, int diametro, int periodoRotacion, int periodoTranslacion, int distanciaMedia) {
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.periodoTranslacion = periodoTranslacion;
        this.distanciaMedia = distanciaMedia;
    }
}
