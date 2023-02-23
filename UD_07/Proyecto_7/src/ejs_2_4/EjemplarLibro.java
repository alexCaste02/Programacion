package ejs_2_4;

import java.time.LocalDate;

public class EjemplarLibro {


    //hay una forma de hacer que funcione el ejemplar sin usar arrays o strings raros?
    private String titulo;

    private LocalDate fechaAdquis;
    private int numEjemplar=1;
    private boolean prestado = false;


    public EjemplarLibro(String titulo){
        this.titulo=titulo;
        this.fechaAdquis = LocalDate.now();
    }

    public EjemplarLibro(EjemplarLibro libro){
        this.titulo=libro.titulo;
        this.fechaAdquis=libro.fechaAdquis;
        this.numEjemplar= libro.numEjemplar+1;
    }

    public boolean prestar(){
        if(!prestado) {
            prestado = true;
            return true;
        }
        return false;
    }

    public boolean devolver(){
        if(prestado) {
            prestado = false;
            return true;
        }
        return false;
    }

    public String toString(){
        return (titulo+" ("+fechaAdquis+") ["+numEjemplar+"]");
    }

}
