import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class testArch {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("EXPERIMENTS/hola.txt");

        PrintWriter pw = new PrintWriter(f);
    }
}
