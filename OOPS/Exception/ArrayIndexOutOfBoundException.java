package OOPS.Exception;

public class ArrayIndexOutOfBoundException {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        try {
            System.out.println(arr1[5]);
        } catch (Exception e) {
            System.out.println("index got out of given array");
        }

    }
}