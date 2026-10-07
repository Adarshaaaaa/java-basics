import java.util.*;

public class VoteEligible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enetr age");
        int age = sc.nextInt();
        System.out.println(voteEligible(age));
    }

    public static String voteEligible(int agee) {
        if (agee >= 18) {
            return " u r eligible to vote";
        } else {
            return "u r not eligible";

        }
    }
}
