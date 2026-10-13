package OOPS.Exception;

class InnerCatch {
    public static void main(String[] args) {
        try {
            int[] arr = { 1, 2 };
            arr[3] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch handled array index issue.");

            try {
                int crash = 5 / 0;
            } catch (ArithmeticException ex) {
                System.out.println("Inner catch handled secondary math issue.");
            }
        }
    }
}