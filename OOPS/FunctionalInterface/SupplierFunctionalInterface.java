package OOPS.FunctionalInterface;

import java.util.function.Supplier;

public class SupplierFunctionalInterface {
    public static void main(String[] args) {
        // Defining a Supplier using a lambda expression
        Supplier<Double> randomValue = () -> Math.random();

        // Getting the value from the supplier
        System.out.println(randomValue.get());
    }
}
