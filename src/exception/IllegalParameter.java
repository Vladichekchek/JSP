package exception;


public class IllegalParameter extends IndexOutOfBoundsException { // ����������, ������������� ��� �������� ���������

    public IllegalParameter(String message){
        super(message);
    }
}
