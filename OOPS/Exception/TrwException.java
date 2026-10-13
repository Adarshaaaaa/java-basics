package OOPS.Exception;

class BankAccount {
    private double balance = 500.0;

    public void withdraw(double amount) {
        if (amount > balance) {

            throw new IllegalArgumentException("Insufficient balance! You only have: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }
}

public class TrwException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        try {
            account.withdraw(600.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }
    }
}
