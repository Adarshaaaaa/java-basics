import java.util.*;

/**
 * SumOdd
 */
public class SumOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number");
        double number = sc.nextDouble();
        System.out.println("The sum of odd numbers is: " + odd(number));
    }

    public static double odd(double num) {
        double sum = 0;
        for (double i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

}
