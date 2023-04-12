import java.util.*;
import java.util.function.Consumer;

public class oli {
    public static void main(String[] args) {

        TreeMap<String,Integer> patatasPower = new TreeMap<>();

        patatasPower.put("patata",10);
        patatasPower.put("batata",20);
        patatasPower.put("papita",50);

        for (Map.Entry<String, Integer> papitaEntrada : patatasPower.entrySet()) {
            System.out.println(papitaEntrada.+" - "+papitaEntrada.getValue());
        }

        for (String papiClave : patatasPower.keySet()) {
            System.out.println(papiClave+" - "+patatasPower.get(papiClave));
        }



        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.fir

    }
}
