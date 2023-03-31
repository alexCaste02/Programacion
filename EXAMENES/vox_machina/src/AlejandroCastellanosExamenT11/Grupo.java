package AlejandroCastellanosExamenT11;

import java.util.*;

public class Grupo {


    //Conjunto donde guardamos Objetos de clase Personaje
    private final Set<Personaje> miembros = new HashSet<>();


    /**
     * Añade un personaje al HashSet 'miembros' del objeto de clase Grupo
     * @param p - Personaje que se añade
     * @return - 'true' si se añade correctamente,
     * 'false' si el personaje ya se encontraba dentro del conjunto
     */
    public boolean incluirPersonaje(Personaje p){
        return miembros.add(p);
    }

    /**
     * Obtiene un personaje que se encuentre en el hashset 'miembros' a partir de un nombre
     *
     * @param nombre - String con el nombre a buscar
     * @return - Personaje con mismo String en su atributo 'nombre'
     */
    public Personaje getMiembro(String nombre){
        for (Personaje miembro : miembros) {
            if (miembro.getNombre().equals(nombre)) return miembro;
        }
        return null;
    }

    /**
     * Obtiene una lista de los magos dentro de conjunto 'miembros'
     * @return - Lista de objetos clase mago
     */
    public List<Mago> dameMagos(){
        List<Mago> listaMagos = new ArrayList<>();
        for (Personaje miembro : miembros) {
            if(miembro instanceof Mago) listaMagos.add((Mago)miembro);
        }
        return listaMagos;
    }

    /**
     * Metodo que 'retira' a todos los personajes que se encuentran
     * en el conjunto 'miembros' llamando al metodo
     * 'retirarse()' de cada objeto clase Personaje
     * ---
     * Muestra un mensaje segun se haya podido o no retirar cada personaje
     *
     */
    public void retirada(){
        for (Personaje miembro : miembros) {
            try {
                miembro.retirarse();
                System.out.println(miembro.getNombre()+" se ha retirado");
            } catch (Exception e) {
                System.out.println(miembro.getNombre()+" no se ha retirado: "+e.getMessage());
            }

        }
    }

    /**
     * Muestra por pantalla los objetos Personaje dentro del conjunto, y sus atributos
     * nombre, fuerza, estado herido (bool) y estado muerto (bool) correspondientes
     * Tambien muestra la suma de sus fuerzas
     */
    public void mostrar(){
        System.out.printf("%-10s - %-6s - %-6s - %-6s %n","Nombre","Fuerza","Herido?","Muerto?");
        int fuerzaTotal = 0;
        for (Personaje miembro : miembros) {
            System.out.println(miembro);
            fuerzaTotal += miembro.getFuerza();
        }
        System.out.println("Fuerza total del grupo: "+fuerzaTotal+"\n");
    }

    /**
     * Elimina los Personajes clase Troll que su atributo 'muerto' sea 'true'
     * @return - Devuelve la cantidad de Trolls eliminados
     */
    public int limpiarGrupo(){
        Iterator<Personaje> iter = miembros.iterator();
        int c = 0;
        while (iter.hasNext()){
            Personaje personaje = iter.next();
            if(personaje instanceof Troll && personaje.isMuerto()) {
                iter.remove();
                c++;
            }
        }
        return c;
    }

    /**
     * Muestra por pantalla los objetos Personaje dentro del conjunto, y sus atributos
     * nombre, fuerza, estado herido (bool) y estado muerto (bool) correspondientes
     * Tambien muestra la suma de sus fuerzas
     * ----
     * Se muestran ordenados por nombre
     * [segun su ordenacion natural (Comparable)]
     */
    public void mostrarGrupo(){
        TreeSet<Personaje> miembrosOrdenados = new TreeSet<>(miembros);

        System.out.printf("%-10s - %-6s - %-6s - %-6s %n","Nombre","Fuerza","Herido?","Muerto?");
        int fuerzaTotal = 0;
        for (Personaje miembro : miembrosOrdenados) {
            System.out.println(miembro);
            fuerzaTotal += miembro.getFuerza();
        }
        System.out.println("Fuerza total del grupo: "+fuerzaTotal+"\n");
    }

    /**
     * Muestra por pantalla los objetos Personaje dentro del conjunto, y sus atributos
     * nombre, fuerza, estado herido (bool) y estado muerto (bool) correspondientes
     * Tambien muestra la suma de sus fuerzas
     * ----
     * Se muestran ordenados por fuerza
     * [hace uso de un lambda equivalente a un Comparator en clase anonima]
     */
    public void mostrarGrupoXFuerza(){
        ArrayList<Personaje> miembrosOrdenadoFuerza = new ArrayList<>(miembros);
        miembrosOrdenadoFuerza.sort((o1, o2) -> o2.fuerza - o1.fuerza);

        System.out.printf("%-10s - %-6s - %-6s - %-6s %n","Nombre","Fuerza","Herido?","Muerto?");
        int fuerzaTotal = 0;
        for (Personaje miembro : miembrosOrdenadoFuerza) {
            System.out.println(miembro);
            fuerzaTotal += miembro.getFuerza();
        }
        System.out.println("Fuerza total del grupo: "+fuerzaTotal+"\n");
    }

}
