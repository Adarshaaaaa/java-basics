
import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms (n): ");
        int n = scanner.nextInt();

        System.out.print("Fibonacci Series: ");

        for (int i = 0; i < n; i++) {
            System.out.print(getFibonacci(i) + " ");
        }

        System.out.println();
        scanner.close();
    }

    public static int getFibonacci(int count) {

        if (count == 0) {
            return 0;
        }
        if (count == 1) {
            return 1;
        }

        return getFibonacci(count - 1) + getFibonacci(count - 2);
    }
}
