package OOPS.Exception;

public class NullException {
    static int a = 10;
    static int b = 0;

    public static void main(String[] args) {
        try {
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {

            System.out.println("cannot devide " + e.getMessage());

        }
    }
}
