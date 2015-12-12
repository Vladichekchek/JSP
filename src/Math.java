import com.sun.org.apache.bcel.internal.generic.FLOAD;


public class Math {

    public int add(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int multiply(int a,int b){
        return a * b;
    }

    public float division(int a, int b){
        return a / b;
    }

    public float getResult(int a, int b, String operation){
        if (operation.equals("+")) return add(a,b);
        if (operation.equals("-")) return minus(a,b);
        if (operation.equals("*")) return multiply(a,b);
        if (operation.equals("/")) return division(a,b);

        return Float.MAX_VALUE;
    }
}
