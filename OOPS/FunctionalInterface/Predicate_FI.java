package OOPS.FunctionalInterface;

import java.util.function.Predicate;

public class Predicate_FI {
    public static void main(String[] args) {

        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Evaluate conditions using .test()
        System.out.println(isEven.test(10)); // Output: true
        System.out.println(isEven.test(7)); // Output: false
    }
}
