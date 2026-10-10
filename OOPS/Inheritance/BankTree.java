package OOPS.Inheritance;

public class BankTree {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("Adarsh");
        sa.displayDetails();
        // BankAccount b1 = new BankAccount("Adarsh");
        // b1.displayDetails();
    }

}

class BankAccount {
    String accountHolder;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate = 4.5;

    SavingsAccount(String accountHolder) {
        super(accountHolder);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest rate: " + interestRate + " %");
    }
}