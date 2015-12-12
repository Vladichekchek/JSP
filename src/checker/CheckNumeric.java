package checker;


public class CheckNumeric { // ���������, �������� �� ���������� � ����� ������ ������ ��� ���

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
