package e_03;

public class CuentaCorriente extends CuentaBancaria{

    public CuentaCorriente(String iban) {
        super(iban);
    }

    @Override
    public void calcularInteres() {
        setSaldo(getSaldo()+getSaldo()*CuentaBancaria.getInteresAnualBasico());
    }
}
