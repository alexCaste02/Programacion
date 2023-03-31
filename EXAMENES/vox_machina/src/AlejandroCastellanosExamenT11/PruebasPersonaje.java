package AlejandroCastellanosExamenT11;

public class PruebasPersonaje {
    public static void main(String[] args) {

        Grupo voxMachina = new Grupo();

        Personaje m1 = new Mago("Mago-A",5);
        Personaje m2 = new Mago("Mago-B",7);
        Personaje m3 = new Mago("Zago-A",2);
        Personaje mx = new Mago("Zago-B",99);

        Personaje t1 = new Troll();
        Personaje t2 = new Troll();
        Personaje t3 = new Troll();
        Personaje t6 = new Troll();
        Personaje t5 = new Troll();
        Personaje t4 = new Troll();


        voxMachina.mostrar();

        System.out.println( voxMachina.incluirPersonaje(m1));
        System.out.println( voxMachina.incluirPersonaje(mx));
        voxMachina.incluirPersonaje(t1);
        voxMachina.incluirPersonaje(t2);

        voxMachina.mostrar();

        m1.setHerido(true);

        t1.setHerido(true);
        t1.setMuerto(true);

        t2.setMuerto(true);
        t2.setHerido(true);

        voxMachina.mostrar();

        voxMachina.incluirPersonaje(m2);
        voxMachina.incluirPersonaje(m3);
        voxMachina.incluirPersonaje(t3);
        voxMachina.incluirPersonaje(t6);
        voxMachina.incluirPersonaje(t5);
        voxMachina.incluirPersonaje(t4);

        t4.setHerido(true);
        t5.setHerido(true);
        m2.setMuerto(true);

        voxMachina.mostrar();

        voxMachina.retirada();
        voxMachina.mostrar();

        System.out.println(voxMachina.limpiarGrupo());
        voxMachina.mostrar();

        System.out.println(voxMachina.getMiembro("Mago-B"));
        System.out.println(voxMachina.getMiembro("Troll_6"));
        System.out.println(voxMachina.getMiembro("Experimento"));

        System.out.println("\n"+voxMachina.dameMagos()+"\n\n");

        voxMachina.mostrarGrupo();

        voxMachina.mostrarGrupoXFuerza();




    }
}
