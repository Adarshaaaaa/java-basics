package OOPS;

import java.util.*;

class account {
    double balance;
    String Holder_name;
    String Bank_type;

    account(double balance, String Holder_name, String Bank_type) {
        this.balance = balance;
        this.Holder_name = Holder_name;
        this.Bank_type = Bank_type;
    }

    void displayinfo() {
        System.out.println("Holder Name : " + Holder_name);
        System.out.println("Bank Type : " + Bank_type);
        System.out.println("Balance : " + balance);
    }

    void deposit(double amount) {
        double old_bal = balance;
        balance += amount;
        System.out.println("Old Balance : " + old_bal);
        System.out.println("Amount Credited : " + amount);
        System.out.println("Available Balance : " + balance);
    }

    void withdraw(double amount) {
        double old_bal = balance;
        System.out.println("Current Balance : " + balance);
        if (amount <= old_bal) {
            balance -= amount;
            System.out.println("Amount Debited : " + amount);
            System.out.println("Available Balance : " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class AccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        account a1 = new account(500000, "Mohamed Rabin", "Savings");
        System.out.println("Choose one Option :");
        System.out.println("1. Show Account Info");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                a1.displayinfo();
                break;
            case 2:
                System.out.println("Enter the amount to deposit :");
                double depositAmount = sc.nextDouble();
                a1.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Enter the amount to withdraw :");
                double withdrawAmount = sc.nextDouble();
                a1.withdraw(withdrawAmount);
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
}