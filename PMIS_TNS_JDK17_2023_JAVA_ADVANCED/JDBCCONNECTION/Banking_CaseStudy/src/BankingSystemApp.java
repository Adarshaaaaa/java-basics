import java.util.List;
import java.util.Scanner;

/**
 * Menu-driven driver class for the Banking System.
 * Uses BankingServiceImpl backed by MySQL via JDBC.
 */
public class BankingSystemApp {

    private static final BankingService service = new BankingServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice : ");
            int choice = readInt();
            switch (choice) {
                case 1: addCustomer();               break;
                case 2: addAccount();                break;
                case 3: addBeneficiary();            break;
                case 4: addTransaction();            break;
                case 5: findCustomerById();          break;
                case 6: listAccountsByCustomer();    break;
                case 7: listTransactionsByAccount(); break;
                case 8: listBeneficiariesByCustomer();break;
                case 9:
                    System.out.println("Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        DBConnection.closeConnection();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Banking System");
        System.out.println("1. Add Customers");
        System.out.println("2. Add Accounts");
        System.out.println("3. Add Beneficiary");
        System.out.println("4. Add Transaction");
        System.out.println("5. Find Customer by Id");
        System.out.println("6. List all Accounts of specific Customer");
        System.out.println("7. List all transactions of specific Account");
        System.out.println("8. List all beneficiaries of specific customer");
        System.out.println("9. Exit");
    }

    // ?? Case 1 ??????????????????????????????????????????????????????????
    private static void addCustomer() {
        System.out.println("Enter Customer Details");
        System.out.print("Customer Id : ");
        int id = readInt();
        System.out.print("Name : ");
        String name = scanner.nextLine().trim();
        System.out.print("Address : ");
        String address = scanner.nextLine().trim();
        System.out.print("Contact No. : ");
        String contact = scanner.nextLine().trim();
        service.addCustomer(new Customer(id, name, address, contact));
        System.out.println("Customer added successfully.");
    }

    // ?? Case 2 ??????????????????????????????????????????????????????????
    private static void addAccount() {
        System.out.println("Enter Account Details");
        System.out.print("Account Id : ");
        int accountId = readInt();
        System.out.print("Customer Id : ");
        int customerId = readInt();
        System.out.print("Account Type Saving/ Current : ");
        String type = scanner.nextLine().trim();
        System.out.print("Balance : ");
        double balance = readDouble();
        service.addAccount(new Account(accountId, customerId, type, balance));
        System.out.println("Account added successfully.");
    }

    // ?? Case 3 ??????????????????????????????????????????????????????????
    private static void addBeneficiary() {
        System.out.println("Enter Beneficiary Details");
        System.out.print("Customer Id : ");
        int customerId = readInt();
        System.out.print("Benefiary Id : ");
        int beneficiaryId = readInt();
        System.out.print("Beneficiary Name : ");
        String name = scanner.nextLine().trim();
        System.out.print("Beneficiary Account No. : ");
        String accountNo = scanner.nextLine().trim();
        System.out.print("Beneficiary Bank details : ");
        String bankDetails = scanner.nextLine().trim();
        service.addBeneficiary(new Beneficiary(beneficiaryId, customerId, name, accountNo, bankDetails));
        System.out.println("Beneficiary added successfully.");
    }

    // ?? Case 4 ??????????????????????????????????????????????????????????
    private static void addTransaction() {
        System.out.println("Enter Transaction Details");
        System.out.print("Account Id : ");
        int accountId = readInt();
        System.out.print("Type (Deposit/Withdrawal) : ");
        String type = scanner.nextLine().trim();
        System.out.print("Account Amount : ");
        double amount = readDouble();

        // Validate account exists
        Account account = service.findAccountById(accountId);
        if (account == null) {
            System.out.println("Error: Account ID " + accountId + " not found.");
            return;
        }
        // Prevent overdraft
        if (type.equalsIgnoreCase("Withdrawal") && amount > account.getBalance()) {
            System.out.println("Error: Insufficient balance. Available: " + account.getBalance());
            return;
        }

        Transaction t = new Transaction(accountId, type, amount);
        service.addTransaction(t);
        System.out.println("Transaction added. Transaction ID: " + t.getTransactionID());
    }

    // ?? Case 5 ??????????????????????????????????????????????????????????
    private static void findCustomerById() {
        System.out.println();
        for (Customer c : service.getAllCustomers()) {
            System.out.println("Cutomer ID: " + c.getCustomerID() + ", Name: " + c.getName());
        }
        System.out.print("Customer Id : ");
        int id = readInt();
        Customer customer = service.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    // ?? Case 6 ??????????????????????????????????????????????????????????
    private static void listAccountsByCustomer() {
        System.out.println();
        for (Account a : service.getAllAccounts()) {
            System.out.println("Account ID: " + a.getAccountID() +
                    ", Customer ID : " + a.getCustomerID() +
                    ", Balance: " + a.getBalance());
        }
        System.out.print("Customer Id : ");
        int customerId = readInt();
        List<Account> accounts = service.getAccountsByCustomerId(customerId);
        System.out.println("Accounts for Customer ID :" + customerId);
        if (accounts.isEmpty()) {
            System.out.println("No accounts found for Customer ID: " + customerId);
        } else {
            for (Account a : accounts) {
                System.out.println("Account ID: " + a.getAccountID() +
                        ", Balance: " + a.getBalance());
            }
        }
    }

    // ?? Case 7 ??????????????????????????????????????????????????????????
    private static void listTransactionsByAccount() {
        System.out.print("Account Id : ");
        int accountId = readInt();
        List<Transaction> transactions = service.getTransactionsByAccountId(accountId);
        System.out.println("Transactions for Account ID :" + accountId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for Account ID: " + accountId);
        } else {
            for (Transaction t : transactions) {
                System.out.println("Transaction ID: " + t.getTransactionID() +
                        ", Type: " + t.getType() +
                        ", Amount: " + t.getAmount() +
                        ", Timestamp: " + t.getTimestamp());
            }
        }
    }

    // ?? Case 8 ??????????????????????????????????????????????????????????
    private static void listBeneficiariesByCustomer() {
        System.out.println();
        for (Beneficiary b : service.getAllBeneficiaries()) {
            System.out.println("Beneficiary ID: " + b.getBeneficiaryID() + ", Name: " + b.getName());
        }
        System.out.println("-------------------------------------");
        System.out.print("Customer Id : ");
        int customerId = readInt();
        List<Beneficiary> beneficiaries = service.getBeneficiariesByCustomerId(customerId);
        System.out.println("Beneficiaries for Customer ID :" + customerId);
        if (beneficiaries.isEmpty()) {
            System.out.println("No beneficiaries found for Customer ID: " + customerId);
        } else {
            for (Beneficiary b : beneficiaries) {
                System.out.println("Beneficiary ID: " + b.getBeneficiaryID() + ", Name: " + b.getName());
            }
        }
    }

    // ?? Helpers ??????????????????????????????????????????????????????????
    private static int readInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static double readDouble() {
        return Double.parseDouble(scanner.nextLine().trim());
    }
}