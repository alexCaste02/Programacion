package e_03;

import java.util.ArrayList;

public class MainCuentas {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> listaCuentas = new ArrayList<>();

        listaCuentas.add(new CuentaAhorro("1234"));
        listaCuentas.add(new CuentaAhorro("asdf"));
        listaCuentas.add(new CuentaCorriente("ueue"));

        listaCuentas.get(0).ingresar(500);
        listaCuentas.get(0).mostrarDatos();
    }
}
