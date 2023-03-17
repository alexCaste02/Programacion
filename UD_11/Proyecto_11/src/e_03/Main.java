package e_03;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Persona> listaPersona = new HashSet<>();


        Persona p1 = new Persona(
                "Vane",
                "666555444",
                "friendscourse@hotmail.com",
                LocalDate.of(1996,7,25)
        );

        Persona p2 = new Persona(
                "Alex",
                "333222111",
                "alexcaste@hotmail.com",
                LocalDate.of(2002,4,23)
        );

        Persona p3 = new Persona(
                "Jacinto",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        Persona p4 = new Persona(
                "Jacinto",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        listaPersona.add(p1);
        listaPersona.add(p2);
        listaPersona.add(p3);
        listaPersona.add(p4);

        int edadMedia=0;
        Persona pMayor = null;
        for (Persona persona : listaPersona) {

            if(pMayor==null || Math.max(persona.getEdad(), pMayor.getEdad()) == persona.getEdad())
                pMayor=persona;

            edadMedia += persona.getEdad();
        }
        edadMedia /= listaPersona.size();


        System.out.println("Media de edad: "+edadMedia);
        System.out.println("Persona mayor: "+pMayor.getNombre());

        System.out.println(listaPersona);

        //No tienen orden

    }

}
