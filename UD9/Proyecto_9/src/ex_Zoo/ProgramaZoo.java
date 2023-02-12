package ex_Zoo;

public class ProgramaZoo {
    public static void main(String[] args) {

        Animal a1=new AnimalTerrestre("Macaco",1,12,8);
        AnimalTerrestre a2=new AnimalTerrestre("Pavo Real",2,10,5);
        Animal a3=new AnimalMarino("Nutria",21,TipoAgua.DULCE,20);
        Animal a4=new AnimalTerrestre("Macaco",22,6,12);
        Animal a5=new AnimalMarino("Macaco",21,TipoAgua.DULCE,20);

        Zoo zoo=new Zoo();
        System.out.println(zoo.addAnimal(a1));
        System.out.println(zoo.addAnimal(a2));
        System.out.println(zoo.addAnimal(a3));
        System.out.println(zoo.addAnimal(a4));
        System.out.println(zoo.addAnimal(a5));
        System.out.println(zoo.addAnimal(new AnimalMarino("Delfín",21,TipoAgua.SALADA,40)));

        zoo.listaAnimales();

        System.out.println("Índice del mono:"+zoo.buscarAnimal("Macaco"));
        zoo.eliminarAnimal("Macaco");

        zoo.listaAnimales();

    }
}
