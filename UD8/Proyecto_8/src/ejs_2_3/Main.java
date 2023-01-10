package ejs_2_3;

public class Main {
    public static void main(String[] args) {

        Bombilla bom1 = new Bombilla();
        System.out.println(bom1.estaLuciendo()?"Esta encendida":"Esta apagada");

        bom1.pulsarInterruptor();
        System.out.println(bom1.estaLuciendo()?"Esta encendida":"Esta apagada");

        bom1.pulsarInterruptorCasa();
        System.out.println(bom1.estaLuciendo()?"Esta encendida":"Esta apagada");

    }
}
