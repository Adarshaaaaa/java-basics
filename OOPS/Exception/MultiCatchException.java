package OOPS.Exception;

/**
 * InnerMultiCatchException
 */
public class MultiCatchException {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // Triggers index error instantly!
            arr[0] = 10 / 0; // This line is never reached
        } catch (ArithmeticException e) {
            System.out.println("First Block: Caught ArithmeticException!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Second Block: Caught ArrayIndexOutOfBoundsException!");
        }
    }

}
