import java.util.*;
import java.lang.*;

public class PowerNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enetr 2 numbers want to get power");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(powers(num1, num2));
    }

    public static double powers(int x, int n) {
        return Math.pow(x, n);
    }
}
