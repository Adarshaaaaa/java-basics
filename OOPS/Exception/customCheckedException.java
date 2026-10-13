package OOPS.Exception;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class customCheckedException {
    private double balance = 500.00;

    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.println("Attempting to withdraw: $" + amount);

        if (amount > balance) {

            throw new InsufficientFundsException("Transaction Denied: Not enough money!");
        }

        balance -= amount;
        System.out.println("Success! New Balance: $" + balance);
    }

    public static void main(String[] args) {
        customCheckedException myAccount = new customCheckedException();

        try {
            myAccount.withdraw(600.00); // This will fail
        } catch (InsufficientFundsException e) {
            System.out.println("Bank System Message: " + e.getMessage());
        }

        System.out.println("\nApplication finished processing safely.");
    }
}
