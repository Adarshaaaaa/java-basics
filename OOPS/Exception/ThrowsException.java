package OOPS.Exception;

public class ThrowsException {

    public static void main(String[] args) {
        int balance = 5000;
        int withdrawal = 7000;

        try {
            if (withdrawal > balance) {
                throw new IllegalArgumentException("Insufficient balance");
            }

            balance -= withdrawal;
            System.out.println("Withdrawal was successful");
            System.out.println("Remaining balance: " + balance);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("program completed");
    }

}
