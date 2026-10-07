
/**
 * basics
 */
import java.util.*;

public class basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter  3 numbers");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();
        average(num1, num2, num3);
    }

    public static void average(double first, double seond, double third) {

        System.out.println((first + seond + third) / 3);

    }
}