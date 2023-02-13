package e_01;

import java.util.ArrayList;

public abstract class Astros {



    private String nombre;
    private double masaKG;
    private double diametroKM;
    private double periodoRotacionDias;
    private double periodoTraslacionDias;
    private Astros cuerpoOrbitado;
    private ArrayList<Astros> orbitadoPor;
    private boolean orbitable;



    public Astros(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTraslacionDias, Astros cuerpoOrbitado, ArrayList<Astros> orbitadoPor, boolean Orbitable) {
        this.nombre = nombre;
        this.masaKG = masaKG;
        this.diametroKM = diametroKM;
        this.periodoRotacionDias = periodoRotacionDias;
        this.periodoTraslacionDias = periodoTraslacionDias;
        this.cuerpoOrbitado = cuerpoOrbitado;
        this.orbitadoPor = orbitadoPor;
        this.orbitable = Orbitable;
    }

    /*GETTERS Y SETTERS*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getMasaKG() {
        return masaKG;
    }
    public void setMasaKG(double masaKG) {
        this.masaKG = masaKG;
    }
    public double getDiametroKM() {
        return diametroKM;
    }
    public void setDiametroKM(double diametroKM) {
        this.diametroKM = diametroKM;
    }
    public double getPeriodoRotacionDias() {
        return periodoRotacionDias;
    }
    public void setPeriodoRotacionDias(double periodoRotacionDias) {
        this.periodoRotacionDias = periodoRotacionDias;
    }
    public double getPeriodoTraslacionDias() {
        return periodoTraslacionDias;
    }
    public void setPeriodoTraslacionDias(double periodoTraslacionDias) {
        this.periodoTraslacionDias = periodoTraslacionDias;
    }
    public Astros getCuerpoOrbitado() {
        return cuerpoOrbitado;
    }
    public void setCuerpoOrbitado(Astros cuerpoOrbitado) {
        this.cuerpoOrbitado = cuerpoOrbitado;
    }
    public ArrayList<Astros> getOrbitadoPor() {
        return orbitadoPor;
    }
    public void setOrbitadoPor(ArrayList<Astros> orbitadoPor) {
        this.orbitadoPor = orbitadoPor;
    }

    public boolean isOrbitable() {
        return orbitable;
    }

    public void setOrbitable(boolean orbitable) {
        this.orbitable = orbitable;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(String.format(
                        """
                        =============================================
                        Astro ------------------ %s
                        Masa ------------------- %.2f
                        Diametro --------------- %.2f
                        Periodo de rotacion ---- %.2f
                        Periodo de translacion - %.2f
                        Orbita a --------------- %s
                        """, nombre, masaKG, diametroKM, periodoRotacionDias, periodoTraslacionDias, cuerpoOrbitado));

        if (orbitable){
            sb.append("Es orbitado por:");
            for ( Astros astro : this.getOrbitadoPor()) {
                sb.append(" - "+astro.nombre+"\n");
            }
        }

        sb.append("\n=============================================");

        return sb.toString();

    }
}
