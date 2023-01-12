package ejs_2_2;

public class Main {
    public static void main(String[] args) {

        Aparato bombilla = new Aparato(100);
        Aparato radiador = new Aparato(2000);
        Aparato plancha = new Aparato(1200);

        System.out.println("El consumo de la instalacion es de "+(bombilla.consumo()+radiador.consumo()+plancha.consumo())+" W");

        bombilla.setEncendido(true);
        plancha.setEncendido(true);

        System.out.println("El consumo de la instalacion es de "+(bombilla.consumo()+radiador.consumo()+plancha.consumo())+" W");

        plancha.setEncendido(false);
        radiador.setEncendido(true);

        System.out.println("El consumo de la instalacion es de "+(bombilla.consumo()+radiador.consumo()+plancha.consumo())+" W");

    }
}
