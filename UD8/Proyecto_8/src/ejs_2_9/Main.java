package ejs_2_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce la longitud del numero que quieres adiviinar");
        MasterMind resp1 = new MasterMind(input.nextInt());
        System.out.println("//NUMERO GENERADO: "+resp1.getNumeroCorrecto()+" //");

        System.out.println("Introduce un numero de "+resp1.getNumeroCorrecto().length()+" digitos");
        resp1.setNumIntroducido(input.next());

    }
}
