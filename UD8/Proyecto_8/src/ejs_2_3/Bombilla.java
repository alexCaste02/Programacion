package ejs_2_3;

public class Bombilla {

    private boolean interruptor=false;
    private static boolean interrCasa=false;

    public void pulsarInterruptor(){
        interruptor=!interruptor;
    }

    public void pulsarInterruptorCasa(){
        interrCasa=!interrCasa;
    }

    public boolean estaLuciendo(){
        return interruptor && interrCasa;
    }

}
