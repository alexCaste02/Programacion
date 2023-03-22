package custom.util;

public class InvalidInputException extends Exception{

    InputType inputType;

    public InvalidInputException(InputType type) {
        super(setMessage(type));
        inputType = type;
    }
    public InvalidInputException() {
        super("No se ha introducido un valor valido");
    }

    public InputType getInputType() {
        return inputType;
    }

    static public String setMessage(InputType inputType) {
        switch (inputType){
            case INT -> {
                return "No se ha introducido un numero entero";
            }
            case DOUBLE -> {
                return "No se ha introducido un numero decimal";
            }
            case YN, OPTION -> {
                return "No se ha introducido una opcion valida";
            }
            default -> {
                return "";
            }
        }
    }
}
