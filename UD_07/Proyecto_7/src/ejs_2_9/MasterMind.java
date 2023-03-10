package ejs_2_9;

import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {

    private String numeroCorrecto = "";
    private StringBuilder numerosDisponibles = new StringBuilder("0123456789");
    private String numIntroducido;
    private int digitosPosCorrecta, digitosMalColocados, intentos = 10;


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


    public void setNumIntroducido(String numIntroducido) {
        this.numIntroducido = numIntroducido;
    }
    public int getDigitosPosCorrecta() {
        return digitosPosCorrecta;
    }
    public int getDigitosMalColocados() {
        return digitosMalColocados;
    }
    public int getIntentos() {
        return intentos;
    }

    public boolean comprobarRespuesta(){

        digitosMalColocados=0;
        digitosPosCorrecta=0;
        intentos--;

        for(int i = 0; i< numeroCorrecto.length(); i++){

            if ( estaDentro(numIntroducido.charAt(i)) ) {

                if (posicionCorrecta(numIntroducido.charAt(i))) {
                    digitosPosCorrecta++;
                } else {
                    digitosMalColocados++;
                }
            }
        }

        return digitosPosCorrecta == numeroCorrecto.length();
    }

    public boolean quedanIntentos(){
        return intentos != 0;
    }

    public boolean estaDentro(char c){
        return numeroCorrecto.indexOf(c) != -1;
    }

    public boolean posicionCorrecta(char c){
        return numeroCorrecto.indexOf(c) == numIntroducido.indexOf(c);
    }
}


