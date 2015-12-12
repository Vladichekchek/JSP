package exception;


public class IllegalParameter extends IndexOutOfBoundsException { // Исключение, выбрасываемое при неверном параметре

    public IllegalParameter(String message){
        super(message);
    }
}
