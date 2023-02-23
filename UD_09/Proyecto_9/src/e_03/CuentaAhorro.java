package e_03;

public class CuentaAhorro extends CuentaBancaria{

    private final double SALDO_MINIMO = 600;

    public CuentaAhorro(String iban) {
        super(iban);
    }

    @Override
    public void calcularInteres() {
        if(getSaldo()<SALDO_MINIMO)
            setSaldo(getSaldo()+getSaldo()*CuentaBancaria.getInteresAnualBasico()/2);
        else
            setSaldo(getSaldo()+getSaldo()*CuentaBancaria.getInteresAnualBasico()*2);
    }
}
