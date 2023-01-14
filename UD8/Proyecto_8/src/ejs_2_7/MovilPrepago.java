package ejs_2_7;

public class MovilPrepago {

    private int numeroMovil;
    private float costeEstableceLLamada;
    private float costeMinutoLLamada;
    private float costeCostumoMB;
    private float saldo;

    public void efectuarLlamada (int segundos){
        saldo-=costeMinutoLLamada*(segundos/60);
    }

    public void navegar(int MB){

    }



}
