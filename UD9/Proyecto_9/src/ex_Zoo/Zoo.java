package ex_Zoo;

import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animal> listaAnimales;

    public Zoo() {
        listaAnimales = new ArrayList<>();
    }

    boolean addAnimal(Animal animal){
        if (listaAnimales.contains(animal))
            return false;
        else
            listaAnimales.add(animal);
        return true;
    }

    public boolean eliminarAnimal(String nombre) {
        int indice = buscarAnimal(nombre);
        if (indice!=-1) {
            listaAnimales.remove(indice);
            return true;
        } else {
            return false;
        }
    }

    int buscarAnimal(String nombre) {
        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i).getNombre().equals(nombre))
                return i;
        }
        return -1;
    }

    public void listaAnimales() {
        System.out.println("Animales en el Zoo");
        for (Animal animal: listaAnimales) {
            System.out.println(animal);
        }
    }

}