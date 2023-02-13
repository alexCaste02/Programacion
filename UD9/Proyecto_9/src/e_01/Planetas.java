package e_01;

import java.util.ArrayList;

public class Planetas extends Astros {

    public Planetas(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTranslacionDias, Double distanciaMediaOrbitaKM, ArrayList<Astros> esOrbitadoPor) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTranslacionDias, distanciaMediaOrbitaKM, Estrella.SOL, esOrbitadoPor);
        Estrella.SOL.getEsOrbitadoPor().add(this);
    }
}
