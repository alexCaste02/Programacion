package e_01;

import java.util.ArrayList;

public class Planetas extends Astros {

    private boolean tieneSatelite;

    public Planetas(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTraslacionDias) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTraslacionDias, Estrella.SOL, new ArrayList<>(),true);
        Estrella.SOL.getOrbitadoPor().add(this);
    }

    public boolean tieneSatelite() {
        return tieneSatelite;
    }
    public void setTieneSatelite(boolean tieneSatelite) {
        this.tieneSatelite = tieneSatelite;
    }

    public void addSatelite(Satelites satelite){
        tieneSatelite = true;
        getOrbitadoPor().add(satelite);
    }

    public void temp(){
        getNombre();
        test=false;
    }




}
