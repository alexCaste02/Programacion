package e_01;

import java.util.ArrayList;
import java.util.EmptyStackException;

public abstract class Astros {

    private String nombre;
    private Double masaKG;
    private Double diametroKM;
    private Double periodoRotacionDias;
    private Double periodoTranslacionDias;
    private Double distanciaMediaOrbitaKM;
    private Astros cuerpoOrbitado;
    private ArrayList<Astros> esOrbitadoPor;

    public Astros(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTranslacionDias, Double distanciaMediaOrbitaKM, Astros cuerpoOrbitado, ArrayList<Astros> esOrbitadoPor) {
        this.nombre = nombre;
        this.masaKG = masaKG;
        this.diametroKM = diametroKM;
        this.periodoRotacionDias = periodoRotacionDias;
        this.periodoTranslacionDias = periodoTranslacionDias;
        this.distanciaMediaOrbitaKM = distanciaMediaOrbitaKM;
        this.cuerpoOrbitado = cuerpoOrbitado;
        this.esOrbitadoPor = esOrbitadoPor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMasaKG() {
        return masaKG;
    }
    public void setMasaKG(Double masaKG) {
        this.masaKG = masaKG;
    }

    public Double getDiametroKM() {
        return diametroKM;
    }
    public void setDiametroKM(Double diametroKM) {
        this.diametroKM = diametroKM;
    }

    public Double getPeriodoRotacionDias() {
        return periodoRotacionDias;
    }
    public void setPeriodoRotacionDias(Double periodoRotacionDias) {
        this.periodoRotacionDias = periodoRotacionDias;
    }

    public Double getPeriodoTranslacionDias() {
        return periodoTranslacionDias;
    }
    public void setPeriodoTranslacionDias(Double periodoTranslacionDias) {
        this.periodoTranslacionDias = periodoTranslacionDias;
    }

    public Double getDistanciaMediaOrbitaKM() {
        return distanciaMediaOrbitaKM;
    }
    public void setDistanciaMediaOrbitaKM(Double distanciaMediaOrbitaKM) {
        this.distanciaMediaOrbitaKM = distanciaMediaOrbitaKM;
    }

    public Astros getCuerpoOrbitado() {
        return cuerpoOrbitado;
    }
    public void setCuerpoOrbitado(Astros cuerpoOrbitado) {
        this.cuerpoOrbitado = cuerpoOrbitado;
    }

    public ArrayList<Astros> getEsOrbitadoPor() {
        return esOrbitadoPor;
    }
    public void setEsOrbitadoPor(ArrayList<Astros> esOrbitadoPor) {
        this.esOrbitadoPor = esOrbitadoPor;
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder(String.format(
                """
                        Astro ------------------ %s
                        Masa ------------------- %.2f
                        Diametro --------------- %.2f
                        Periodo de rotacion ---- %.2f
                        Periodo de translacion - %.2f
                        Distancia media -------- %.2f
                        Orbita a --------------- %s
                        Es orbitado por:""", nombre, masaKG, diametroKM, periodoRotacionDias, periodoTranslacionDias, distanciaMediaOrbitaKM, cuerpoOrbitado));

        for (Astros astros : esOrbitadoPor) {
            texto.append(" - "+astros.nombre+"\n");
        }

        return texto.toString();

    }
}
