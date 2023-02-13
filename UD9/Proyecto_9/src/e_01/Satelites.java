package e_01;

import java.util.ArrayList;

public class Satelites extends Astros {

    public Satelites(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTranslacionDias, Double distanciaMediaOrbitaKM, Astros cuerpoOrbitado, ArrayList<Astros> esOrbitadoPor) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTranslacionDias, distanciaMediaOrbitaKM, cuerpoOrbitado, esOrbitadoPor);
        cuerpoOrbitado.getEsOrbitadoPor().add(this);
    }

}
