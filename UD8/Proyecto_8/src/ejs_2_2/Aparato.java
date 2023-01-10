package ejs_2_2;

public class Aparato {

    private int potencia;
    private boolean encendido=false;

    public Aparato (int potencia) {
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int consumo() {
        if (encendido)
            return potencia;
        else
            return 0;
    }


}
