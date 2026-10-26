package OOPS.FunctionalInterface;

import java.util.function.Consumer;

public class ConsumerFunctionalInterface {
    public static void main(String[] args) {
        // T (Input) is String. It performs an action and returns void.
        Consumer<String> printUpper = str -> System.out.println(str.toUpperCase());

        // Invoke the action using .accept()
        printUpper.accept("susheela"); // Output: SUSHEELA
    }
}
