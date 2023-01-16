//package ejs_2_9_ALT;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        boolean adivinado = false;
//
//        System.out.println("Introduce la longitud del numero que quieres adivinar");
//        MasterMind resp1 = new MasterMind(input.nextInt());
////        System.out.println("## NUMERO GENERADO: " + resp1.getNumeroCorrecto() + " ##");
//
//
//        while (resp1.quedanIntentos() && !adivinado) {
//            System.out.println(resp1.getIntentos() + " intento(s) restante(s)");
//            System.out.println("Introduce un numero de " + resp1.getNumeroCorrecto().length() + " digitos");
//            resp1.setNumIntroducido(input.next());
//
//            if(resp1.comprobarRespuesta()) {
//                adivinado = true;
//            } else {
//                System.out.println(resp1.getDigitosPosCorrecta() + " digito(s) bien colocado(s), " + resp1.getDigitosMalColocados() + " digito(s) mal colocado(s)");
//            }
//        }
//
//        System.out.println(adivinado?"Has acertado":"Te has quedado sin intentos");
//    }
//}

package ejs_2_9_ALT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la longitud del numero que quieres adivinar:");
        MasterMind game = new MasterMind(input.nextInt());
        while (game.getAttemptsLeft() > 0) {
            System.out.println(game.getAttemptsLeft() + " intento(s) restante(s)");
            System.out.println("Introduce un numero de " + game.getCorrectNumber().length() + " digitos:");
            game.setEnteredNumber(input.next());
            if (game.checkAnswer()) {
                System.out.println("Has acertado!");
                break;
            } else {
                System.out.println(game.getCorrectlyPlacedDigits() + " digito(s) bien colocado(s), " + game.getIncorrectlyPlacedDigits() + " digito(s) mal colocado(s)");
            }
        }
        if (game.getAttemptsLeft() == 0) {
            System.out.println("Te has quedado sin intentos. El numero correcto era: " + game.getCorrectNumber());
        }
    }
}


