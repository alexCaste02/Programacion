package ejs_2_9;

import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {

    String numeroCorrecto = "";
    StringBuilder numerosDisponibles = new StringBuilder("0123456789");
    String numIntroducido;
    int digitosPosCorrecta, digitosMalColocados;


    public MasterMind(int longitudNumero) {

        int posRand;

        for(int i=longitudNumero; i>0; i--){

            posRand = ThreadLocalRandom.current().nextInt(0,numerosDisponibles.length());
            numeroCorrecto += numerosDisponibles.charAt(posRand);
            numerosDisponibles.deleteCharAt(posRand);

        }

    }


    public String getNumeroCorrecto() {
        return numeroCorrecto;
    }
    public void setNumeroCorrecto(String numeroCorrecto) {
        this.numeroCorrecto = numeroCorrecto;
    }

    public StringBuilder getNumerosDisponibles() {
        return numerosDisponibles;
    }
    public void setNumerosDisponibles(StringBuilder numerosDisponibles) {
        this.numerosDisponibles = numerosDisponibles;
    }

    public String getNumIntroducido() {
        return numIntroducido;
    }
    public void setNumIntroducido(String numIntroducido) {
        this.numIntroducido = numIntroducido;
    }

    public int getDigitosPosCorrecta() {
        return digitosPosCorrecta;
    }
    public void setDigitosPosCorrecta(int digitosPosCorrecta) {
        this.digitosPosCorrecta = digitosPosCorrecta;
    }

    public int getDigitosMalColocados() {
        return digitosMalColocados;
    }
    public void setDigitosMalColocados(int digitosMalColocados) {
        this.digitosMalColocados = digitosMalColocados;
    }





    public void comprobarRespuesta(){

        for(int i = 0; i< numeroCorrecto.length(); i++){

            if ( estaDentro(numIntroducido.charAt(i)) ) {

                if (posicionCorrecta(numIntroducido.charAt(i))) {
                    digitosPosCorrecta++;
                }

                digitosMalColocados++;

            }

        }

    }

    public boolean estaDentro(char c){
        return numeroCorrecto.indexOf(c) != -1;
    }

    public boolean posicionCorrecta(char c){
        return numeroCorrecto.indexOf(c) == numIntroducido.indexOf(c);
    }
}


