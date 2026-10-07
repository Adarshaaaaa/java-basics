import java.util.*;

public class EnterNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positive = 0;
        int negative = 0;
        int zero = 0;
        char character;

        do {
            System.out.println("enter number");
            int num = sc.nextInt();
            if (num > 0) {
                positive += 1;
            } else if (num < 0) {
                negative += 1;
            } else {
                zero += 1;
            }
            System.out.println("do u want to enter y/n");
            character = sc.next().toLowerCase().charAt(0);

        } while (character == 'y');
        System.out.println(" positive are:" + positive);
        System.out.println("negative are" + negative);
        System.out.println("zeros are" + zero);
    }

}
