package OOPS.Exception;

public class TryWithFinally {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        try {
            System.out.println(arr1[5]);
        } finally {
            System.out.println("finally got executed sucessfully ");
        }
    }

}
