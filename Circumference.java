import java.util.*;

public class Circumference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the radius");
        double radius = sc.nextDouble();
        System.out.println("circumference is" + circumference(radius));
    }

    public static double circumference(double r) {
        return 2 * 3.14 * r;
    }
}
