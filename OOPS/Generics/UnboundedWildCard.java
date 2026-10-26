package OOPS.Generics;

import java.util.*;

class UnboundedWildCard {
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anish", "Varun", "Bhumi");
        List<Integer> nums = Arrays.asList(100, 99, 98);
        List<Double> prices = Arrays.asList(99.5, 99.6, 99.7);

        System.out.println("name: ");
        printList(names);

        System.out.println("\nNumbers: ");
        printList(nums);

        System.out.println("\nprices: ");
        printList(prices);
    }
}
