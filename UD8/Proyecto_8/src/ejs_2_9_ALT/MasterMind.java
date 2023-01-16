//package ejs_2_9_ALT;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//public class MasterMind {
//
//    private String numeroCorrecto = "";
//    private StringBuilder numerosDisponibles = new StringBuilder("0123456789");
//    private String numIntroducido;
//    private int digitosPosCorrecta, digitosMalColocados, intentos = 10;
//
//
//    public MasterMind(int longitudNumero) {
//
//        int posRand;
//
//        for(int i=longitudNumero; i>0; i--){
//
//            posRand = ThreadLocalRandom.current().nextInt(0,numerosDisponibles.length());
//            numeroCorrecto += numerosDisponibles.charAt(posRand);
//            numerosDisponibles.deleteCharAt(posRand);
//
//        }
//
//    }
//
//
//    public String getNumeroCorrecto() {
//        return numeroCorrecto;
//    }
//    public void setNumeroCorrecto(String numeroCorrecto) {
//        this.numeroCorrecto = numeroCorrecto;
//    }
//
//    public StringBuilder getNumerosDisponibles() {
//        return numerosDisponibles;
//    }
//    public void setNumerosDisponibles(StringBuilder numerosDisponibles) {
//        this.numerosDisponibles = numerosDisponibles;
//    }
//
//    public String getNumIntroducido() {
//        return numIntroducido;
//    }
//    public void setNumIntroducido(String numIntroducido) {
//        this.numIntroducido = numIntroducido;
//    }
//
//    public int getDigitosPosCorrecta() {
//        return digitosPosCorrecta;
//    }
//    public void setDigitosPosCorrecta(int digitosPosCorrecta) {
//        this.digitosPosCorrecta = digitosPosCorrecta;
//    }
//
//    public int getDigitosMalColocados() {
//        return digitosMalColocados;
//    }
//    public void setDigitosMalColocados(int digitosMalColocados) {
//        this.digitosMalColocados = digitosMalColocados;
//    }
//
//    public int getIntentos() {
//        return intentos;
//    }
//    public void setIntentos(int intentos) {
//        this.intentos = intentos;
//    }
//
//    public boolean comprobarRespuesta() {
//
//        digitosMalColocados = 0;
//        digitosPosCorrecta = 0;
//        intentos--;
//
//        for (int i = 0; i < numeroCorrecto.length(); i++) {
//
//            if (estaDentro(numIntroducido.charAt(i))) {
//
//                if (posicionCorrecta(numIntroducido.charAt(i))) {
//                    digitosPosCorrecta++;
//                } else {
//                    digitosMalColocados++;
//                }
//            }
//        }
//
//        return digitosPosCorrecta == numeroCorrecto.length();
//
//    }
//
//    public boolean quedanIntentos(){
//        return intentos > 0;
//    }
//
//    public boolean estaDentro(char c){
//        return numeroCorrecto.indexOf(c) != -1;
//    }
//
//    public boolean posicionCorrecta(char c){
//        return numeroCorrecto.indexOf(c) == numIntroducido.indexOf(c);
//    }
//
//}

package ejs_2_9_ALT;

import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {

    private final int totalAttempts = 10;
    private final int numberLength;
    private final String correctNumber;
    private String enteredNumber;
    private int attemptsLeft = totalAttempts;
    private int correctlyPlacedDigits;
    private int incorrectlyPlacedDigits;

    public MasterMind(int numberLength) {
        this.numberLength = numberLength;
        StringBuilder availableNumbers = new StringBuilder("0123456789");
        StringBuilder correctNumberBuilder = new StringBuilder();
        int posRand;
        for (int i = 0; i < numberLength; i++) {
            posRand = ThreadLocalRandom.current().nextInt(0, availableNumbers.length());
            correctNumberBuilder.append(availableNumbers.charAt(posRand));
            availableNumbers.deleteCharAt(posRand);
        }
        correctNumber = correctNumberBuilder.toString();
    }

    public String getCorrectNumber() {
        return correctNumber;
    }

    public String getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(String enteredNumber) {
        this.enteredNumber = enteredNumber;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public int getCorrectlyPlacedDigits() {
        return correctlyPlacedDigits;
    }

    public int getIncorrectlyPlacedDigits() {
        return incorrectlyPlacedDigits;
    }

    public boolean checkAnswer() {
        if (enteredNumber.length() != numberLength) {
            throw new IllegalArgumentException("Entered number should have " + numberLength + " digits");
        }
        if (attemptsLeft == 0) {
            return false;
        }
        attemptsLeft--;
        correctlyPlacedDigits =


