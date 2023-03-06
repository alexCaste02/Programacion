package e_08;



import custom.util.InvalidInputException;

import java.util.ArrayList;

public class CuentaBancaria {

    private final String TITULAR;
    private final String IBAN;
    private double saldo = 0;
    private ArrayList<Double> movimientos = new ArrayList<>();

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
    public ArrayList<Double> getMovimientos() {
        return movimientos;
    }

    public void setSaldo(double saldo) throws SaldoInvalidoException {

        if (saldo<50){
            throw new SaldoInvalidoException();
        }

        this.saldo = saldo;
    }

    /* OTROS */
    public void ingresar(double dinero) throws InvalidInputException, AvisarHaciendaException, SaldoInvalidoException {

        if (dinero>3000){
            throw new AvisarHaciendaException();
        } else if (dinero<=0) {
            throw new InvalidInputException();
        }

        setSaldo(saldo+dinero);
        movimientos.add(dinero);
    }

    public void retirar(double dinero) throws InvalidInputException, AvisarHaciendaException, SaldoInvalidoException {

        if(dinero<=0){
            throw new InvalidInputException();
        } else if (dinero>3000) {
            throw new AvisarHaciendaException();
        }

        setSaldo(saldo-dinero);
        movimientos.add(-dinero);
    }

    @Override
    public String toString() {
        return String.format("""
                        ===================================
                        Titular: %s
                        IBAN: %s
                        Saldo: %.2f
                        ===================================
                        """,TITULAR,IBAN,saldo);
    }

    // ES1234567890123456789012

}
