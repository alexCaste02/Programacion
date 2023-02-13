package e_03;

public abstract class CuentaBancaria {
    private final String iban;
    private double saldo;
    private static final double INTERES_ANUAL_BASICO = 25;

    public CuentaBancaria(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void mostrarDatos(){
        System.out.println(this);
    }

    public static double getInteresAnualBasico(){
        return INTERES_ANUAL_BASICO;
    }



    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public boolean ingresar(double cantidad){

        add(cantidad);
        return true;
    }

    public boolean retirar(double cantidad){
        add(-cantidad);
        return true;
    }

    public boolean traspasar(CuentaBancaria recipiente, double cantidad){
        this.add(-cantidad);
        recipiente.add(cantidad);
        return true;
    }

    private boolean add(double cantidad){
        saldo+=cantidad;
        return true;
    }

    public abstract void calcularInteres();

}
