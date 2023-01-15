package ejs_2_8;

public class CuentaBancaria {

    private final String TITULAR;
    private final String IBAN;
    private double saldo = 0;

    /* CONS */
    public CuentaBancaria(String titular, String iban) {
        this.TITULAR = titular;
        this.IBAN = iban;
    }

    /* G y S */
    public String getTITULAR() {
        return TITULAR;
    }
    public String getIBAN() {
        return IBAN;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /* OTROS */
    @Override
    public String toString() {
        return  "Titular: " + TITULAR +
                "\nIBAN: " + IBAN +
                "\nSaldo: " + saldo;
    }

    public boolean ingresar(double dinero){

        if(dinero>0){

            if (dinero>3000){
                System.out.println("AVISO: Notificar a hacienda");
            }
            saldo+=dinero;
            return true;

        }

        return false;
    }

    public int retirar(double dinero){
        if(dinero>0){

            if(saldo-dinero<-50)
                return -1;
            if (saldo<0){
                System.out.println("AVISO: Saldo negativo");
            }
            saldo-=dinero;
            return 1;

        }

        return 0;
    }


}
