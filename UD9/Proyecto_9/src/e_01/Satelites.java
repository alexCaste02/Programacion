package e_01;

import java.util.ArrayList;

public class Satelites extends Astros {

    private boolean conRotacionSincrona;

    public Satelites(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTraslacionDias, Astros cuerpoOrbitado, boolean conRotacionSincrona) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTraslacionDias, cuerpoOrbitado, null, false);
        this.conRotacionSincrona = conRotacionSincrona;
    }


    public boolean isConRotacionSincrona() {
        return conRotacionSincrona;
    }
    public void setConRotacionSincrona(boolean conRotacionSincrona) {
        this.conRotacionSincrona = conRotacionSincrona;
    }
}
