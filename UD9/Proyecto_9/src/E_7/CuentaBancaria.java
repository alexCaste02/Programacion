package E_7;

import java.util.ArrayList;

public class CuentaBancaria {

    private final String TITULAR;
    private final String IBAN;
    private double saldo = 0;
    private static ArrayList<CuentaBancaria> listaCuentas = new ArrayList<>();
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
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static ArrayList<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public static void setListaCuentas(ArrayList<CuentaBancaria> listaCuentas) {
        CuentaBancaria.listaCuentas = listaCuentas;
    }

    public ArrayList<Double> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Double> movimientos) {
        this.movimientos = movimientos;
    }

    /* OTROS */
    @Override
    public String toString() {
        return  "\n===================================\n"+
                "Titular: " + TITULAR +
                "\nIBAN: " + IBAN +
                "\nSaldo: " + saldo+
                "\n===================================\n";

    }

    public boolean ingresar(double dinero){

        if(dinero>0){

            if (dinero>3000){
                System.out.println("AVISO: Notificar a hacienda");
            }

            movimientos.add(dinero);
            saldo+=dinero;
            return true;

        }

        return false;
    }

    public int retirar(double dinero){
        if(dinero>0){

            if(saldo-dinero<-50)
                return -1;

            saldo-=dinero;

            if (saldo<0){
                System.out.println("AVISO: Saldo negativo");
            }

            if (dinero>3000){
                System.out.println("AVISO: Notificar a hacienda");
            }

            movimientos.add(-dinero);
            return 1;

        }

        return 0;
    }

    public static void addCuentaBancaria(CuentaBancaria cuenta){
        listaCuentas.add(cuenta);
    }

    public static CuentaBancaria existeCuenta (String inputIBAN){
        for (CuentaBancaria listaCuenta : listaCuentas) {
            if (listaCuenta.IBAN.equals(inputIBAN))
                return listaCuenta;
        }
        return null;
    }

    // ES1234567890123456789012

}
