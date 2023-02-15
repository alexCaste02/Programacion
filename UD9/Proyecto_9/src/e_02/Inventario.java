package e_02;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Mascotas> inventario = new ArrayList<>();

    //TODO: menus AAAAAAAAAAAA
    public void mostrarListaAnimales(){
        for (Mascotas mascota : inventario) {
            System.out.println(mascota.getNombre()+": "+mascota.getClass());
        }
    }

    //TODO: equals para encontrar animal especifico
    public void mostrarDatosAnimal(){

    }

    public void mostrarDatosAllAnimales(){
        for (Mascotas mascota : inventario) {
            mascota.muestra();
        }
    }

    public void addAnimal(){

        //TODO: pedir cosas por teclado
        //TODO: switch para diferenciar segun clase
        inventario.add(null); {
        }
    }

    //TODO: equals para encontrar animal especifico
    public void removeAnimal(){

    }

    public void clearInvetario(){
        inventario.clear();
    }

}
