package e_05;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main_v2 {

    public static void main(String[] args) {

        Set<Persona_v2> listaPersonaV2 = new LinkedHashSet<>();


        Persona_v2 p1 = new Persona_v2(
                "Vane",
                "666555444",
                "friendscourse@hotmail.com",
                LocalDate.of(1996,7,25)
        );

        Persona_v2 p2 = new Persona_v2(
                "Alex",
                "333222111",
                "alexcaste@hotmail.com",
                LocalDate.of(2002,4,23)
        );

        Persona_v2 p3 = new Persona_v2(
                "Jacinto",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        Persona_v2 p4 = new Persona_v2(
                "JACINTO",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        listaPersonaV2.add(p1);
        listaPersonaV2.add(p2);
        listaPersonaV2.add(p3);
        listaPersonaV2.add(p4);


        int edadMedia=0;
        Persona_v2 pMayor = null;
        for (Persona_v2 personaV2 : listaPersonaV2) {

            if(pMayor==null || Math.max(personaV2.getEdad(), pMayor.getEdad()) == personaV2.getEdad())
                pMayor= personaV2;

            edadMedia += personaV2.getEdad();
        }
        edadMedia /= listaPersonaV2.size();


        System.out.println("Media de edad: "+edadMedia);
        System.out.println("Persona mayor: "+pMayor.getNombre());

        System.out.println(listaPersonaV2);

        //Orden de insercion

    }

}
