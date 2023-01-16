package ejs_2_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean adivinado = false;

        System.out.println("\nIntroduce la longitud del numero que quieres adivinar");
        MasterMind resp1 = new MasterMind(input.nextInt());
//        System.out.println("## NUMERO GENERADO: " + resp1.getNumeroCorrecto() + " ##");

        while (resp1.quedanIntentos()) {

            System.out.println(resp1.getIntentos() + " intento(s) restante(s)");

            System.out.println("Introduce un numero de " + resp1.getNumeroCorrecto().length() + " digitos");
            resp1.setNumIntroducido(input.next());

            if(resp1.comprobarRespuesta()) {
                adivinado = true;
                break;
            }

            System.out.println(resp1.getDigitosPosCorrecta() + " digito(s) bien colocado(s), " + resp1.getDigitosMalColocados() + " digito(s) mal colocado(s)");

        }

        System.out.println(adivinado?"Has acertado":"Te has quedado sin intentos");

    }

}