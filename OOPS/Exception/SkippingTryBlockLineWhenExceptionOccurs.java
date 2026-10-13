package OOPS.Exception;

class SkippingTryBlockLineWhenExceptionOccurs {
    public static void main(String[] args) {
        try {
            int data = 10 / 0;
            System.out.println("This line is skipped!");
        } catch (ArithmeticException e) {
            System.out.println("Caught Error: Cannot divide by zero.");
        }
        System.out.println("Program stays alive!");
    }
}