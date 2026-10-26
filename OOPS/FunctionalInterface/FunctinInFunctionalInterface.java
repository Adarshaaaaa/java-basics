package OOPS.FunctionalInterface;

import java.util.function.Function;

public class FunctinInFunctionalInterface {
    public static void main(String[] args) {
        // T (Input) is String, R (Output) is Integer
        Function<String, Integer> stringLength = str -> str.length();

        // Invoke the method using .apply()
        int length = stringLength.apply("Susheela");

        System.out.println(length); // Output: 8
    }
}
