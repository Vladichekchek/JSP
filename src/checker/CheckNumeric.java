package checker;


public class CheckNumeric { // Проверяет, является ли переданная в метод строка числом или нет

    public static boolean isDigit(String value){
        try {
            Integer.parseInt(value);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
}

}
