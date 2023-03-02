package e_09.Excepciones;

public class ValorIncorrecto extends Exception{
    private int num;

    public ValorIncorrecto(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ValorIncorrecto{" +
                "num=" + num +
                '}';
    }
}
