package OOPS.Generics;

public class GenericMethod {

    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5 };

        String[] stringArray = { "Java", "Generics", "Compile-Time", "Safety" };

        System.out.println("Printing Integer Array:");

        printArray(intArray);

        System.out.println("\nPrinting String Array:");

        printArray(stringArray);

    }

}
