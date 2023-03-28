package e_AgendaTelefonica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agenda {

    private static List<Registro> registros = new ArrayList<>();

    public static List<Registro> getRegistros() {
        return registros;
    }

    public static void setRegistros(List<Registro> registros) {
        Agenda.registros = registros;
    }
}
