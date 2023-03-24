package e_10;

import e_05.Persona_v2;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Persona_v2> personaSet = new TreeSet<>();
        //no es comparable

        Set<Persona_v3> personaSetV3 = new TreeSet<>();

        Persona_v3 p1 = new Persona_v3(
                "Vane",
                "666555444",
                "friendscourse@hotmail.com",
                LocalDate.of(1996,7,25)
        );

        Persona_v3 p2 = new Persona_v3(
                "Alex",
                "333222111",
                "alexcaste@hotmail.com",
                LocalDate.of(2002,4,23)
        );

        Persona_v3 p3 = new Persona_v3(
                "Jacinto",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        Persona_v3 p4 = new Persona_v3(
                "JACINTO",
                "123123123",
                "jchamp@hotmail.com",
                LocalDate.of(1977,10,24)
        );

        personaSetV3.add(p1);
        personaSetV3.add(p2);
        personaSetV3.add(p3);
        personaSetV3.add(p4);

        System.out.println(personaSetV3);

    }
}
