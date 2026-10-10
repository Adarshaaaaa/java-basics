package OOPS;

class BankAccount1 {
    private String holderName;
    private double balance;

    public BankAccount1(String holderName, double balance) {
        this.holderName = holderName;
        setBalance(balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        } else {
            System.out.println("Invalid balance: cannot be negative!");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount1 acc = new BankAccount1("Alex", 500);
        acc.setBalance(-100);
        System.out.println(acc.getBalance());
    }
}