import java.time.LocalDateTime;

/**
 * Represents a banking transaction (Deposit or Withdrawal).
 * When created fresh: transactionID defaults to 0 (DB will assign the real ID via AUTO_INCREMENT).
 * When loaded from DB: setTransactionID() is called by the mapper.
 */
public class Transaction {

    private int transactionID;
    private int accountID;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    // Constructor used when creating a new transaction from user input
    public Transaction(int accountID, String type, double amount) {
        this.transactionID = 0; // will be set after DB insert
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public int getTransactionID() { return transactionID; }
    public void setTransactionID(int transactionID) { this.transactionID = transactionID; }
    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Transaction{transactionID=" + transactionID + ", accountID=" + accountID +
                ", type='" + type + "', amount=" + amount + ", timestamp=" + timestamp + "}";
    }
}