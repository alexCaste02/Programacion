package e_12;


import e_10.Persona_v3;

import java.time.LocalDate;
import java.util.*;

public class Main_12 {
    public static void main(String[] args) {

        List<Persona_v3> listaPersonasV3 = new ArrayList<>();

        Persona_v3 p1 = new Persona_v3(
                "Vane",
                "666555444",
                "friendscourse@hotmail.com",
                LocalDate.of(1996,7,25)
        );

        Persona_v3 p2 = new Persona_v3(
                "Alex",
                "333222111",
                "zzzalexcaste@hotmail.com",
                LocalDate.of(2002,4,23)
        );

        Persona_v3 p3 = new Persona_v3(
                "Jacinto",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        Persona_v3 p4 = new Persona_v3(
                "Joselito",
                "123123123",
                "jchamp2@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        Persona_v3 p5 = new Persona_v3(
                "Joselito",
                "123123123",
                "jchamp2@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        listaPersonasV3.add(p1);
        listaPersonasV3.add(p2);
        listaPersonasV3.add(p3);
        listaPersonasV3.add(p4);
        listaPersonasV3.add(p5);


        System.out.println(listaPersonasV3);


        Set<Persona_v3> setPersonaV3 = new LinkedHashSet<>(listaPersonasV3);

        System.out.println(setPersonaV3);


    }
}

