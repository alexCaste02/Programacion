package ejs_2_4;

import java.time.LocalDate;

public class EjemplarLibro {

    private static int numEjemplarGlobal=0;

    private String titulo;
    private LocalDate fechaAdquis;
    private int numEjemplar= numEjemplarGlobal;
    private boolean prestado=false;


    public EjemplarLibro(String titulo){
        this.titulo=titulo;
        fechaAdquis = LocalDate.now();
        numEjemplarGlobal++;
    }

    public EjemplarLibro(EjemplarLibro libro){

    }

}
