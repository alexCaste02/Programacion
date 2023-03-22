package custom.util;

import java.util.Scanner;

public class InputReader {

    static Scanner input = new Scanner(System.in);

    public static int readAndValidateInt() throws InvalidInputException {

        String inputLine = input.nextLine();
        if (inputLine.matches("-?\\d+")) return Integer.parseInt(inputLine);
        throw new InvalidInputException(InputType.INT);

    }

    public static double readAndValidateDouble() throws InvalidInputException {

        String inputLine = input.nextLine();
        if (inputLine.matches("-?\\d+([.]\\d+)?")) return Double.parseDouble(inputLine);
        throw new InvalidInputException(InputType.DOUBLE);

    }

    public static int readAndValidateOption(int maxValidOption) throws InvalidInputException {

        String inputLine = input.nextLine();
        if (inputLine.matches("\\d")) {
            int inputInt = Integer.parseInt(inputLine);
            if (inputInt <= maxValidOption) {
                return inputInt;
            }
        }
        throw new InvalidInputException(InputType.OPTION);

    }

    public static boolean readAndValidateYN() throws InvalidInputException {

        String inputLine = input.nextLine();
        if (inputLine.matches("[Yy]")) return true;
        else if (inputLine.matches("[Nn]")) {
            return false;
        }
        throw new InvalidInputException(InputType.OPTION);

    }


}
