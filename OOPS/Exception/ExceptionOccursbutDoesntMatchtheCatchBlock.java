package OOPS.Exception;

public class ExceptionOccursbutDoesntMatchtheCatchBlock {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (ArithmeticException e) {

            System.out.println("Caught math exception.");
        }

        System.out.println("This will never print.");
    }

}
