import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JDBC-based implementation of BankingService.
 * All data is persisted in MySQL (banking_db).
 */
public class BankingServiceImpl implements BankingService {

    private final Connection conn;

    public BankingServiceImpl() {
        this.conn = DBConnection.getConnection();
    }

    // ================================================================
    //  ADD operations
    // ================================================================

    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customer_id, name, address, contact) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customer.getCustomerID());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getContact());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DB] addCustomer failed: " + e.getMessage());
        }
    }

    @Override
    public void addAccount(Account account) {
        String sql = "INSERT INTO accounts (account_id, customer_id, type, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, account.getAccountID());
            ps.setInt(2, account.getCustomerID());
            ps.setString(3, account.getType());
            ps.setDouble(4, account.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DB] addAccount failed: " + e.getMessage());
        }
    }

    /**
     * Inserts the transaction row, then updates account balance:
     *   Deposit    -> balance += amount
     *   Withdrawal -> balance -= amount
     * Both operations run in a single transaction (atomic).
     */
    @Override
    public void addTransaction(Transaction transaction) {
        String insertSql = "INSERT INTO transactions (account_id, type, amount, timestamp) VALUES (?, ?, ?, ?)";
        String depositSql   = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        String withdrawSql  = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        try {
            conn.setAutoCommit(false);

            // 1. Insert transaction row
            try (PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, transaction.getAccountID());
                ps.setString(2, transaction.getType());
                ps.setDouble(3, transaction.getAmount());
                ps.setTimestamp(4, Timestamp.valueOf(transaction.getTimestamp()));
                ps.executeUpdate();

                // Capture auto-generated transaction ID
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    transaction.setTransactionID(generatedKeys.getInt(1));
                }
            }

            // 2. Update account balance
            String updateSql = transaction.getType().equalsIgnoreCase("Deposit") ? depositSql : withdrawSql;
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setDouble(1, transaction.getAmount());
                ps.setInt(2, transaction.getAccountID());
                ps.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            System.err.println("[DB] addTransaction failed: " + e.getMessage());
            try { conn.rollback(); } catch (SQLException ex) { /* ignore */ }
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ex) { /* ignore */ }
        }
    }

    @Override
    public void addBeneficiary(Beneficiary beneficiary) {
        String sql = "INSERT INTO beneficiaries (beneficiary_id, customer_id, name, account_number, bank_details) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, beneficiary.getBeneficiaryID());
            ps.setInt(2, beneficiary.getCustomerID());
            ps.setString(3, beneficiary.getName());
            ps.setString(4, beneficiary.getAccountNumber());
            ps.setString(5, beneficiary.getBankDetails());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DB] addBeneficiary failed: " + e.getMessage());
        }
    }

    // ================================================================
    //  FIND BY ID operations
    // ================================================================

    @Override
    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapCustomer(rs);
        } catch (SQLException e) {
            System.err.println("[DB] findCustomerById failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapAccount(rs);
        } catch (SQLException e) {
            System.err.println("[DB] findAccountById failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Transaction findTransactionById(int id) {
        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapTransaction(rs);
        } catch (SQLException e) {
            System.err.println("[DB] findTransactionById failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Beneficiary findBeneficiaryById(int id) {
        String sql = "SELECT * FROM beneficiaries WHERE beneficiary_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapBeneficiary(rs);
        } catch (SQLException e) {
            System.err.println("[DB] findBeneficiaryById failed: " + e.getMessage());
        }
        return null;
    }

    // ================================================================
    //  FILTERED LIST operations
    // ================================================================

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) {
        List<Account> result = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) result.add(mapAccount(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getAccountsByCustomerId failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> result = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE account_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) result.add(mapTransaction(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getTransactionsByAccountId failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<Beneficiary> getBeneficiariesByCustomerId(int customerId) {
        List<Beneficiary> result = new ArrayList<>();
        String sql = "SELECT * FROM beneficiaries WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) result.add(mapBeneficiary(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getBeneficiariesByCustomerId failed: " + e.getMessage());
        }
        return result;
    }

    // ================================================================
    //  GET ALL operations
    // ================================================================

    @Override
    public Collection<Account> getAllAccounts() {
        List<Account> result = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) result.add(mapAccount(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getAllAccounts failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        List<Customer> result = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) result.add(mapCustomer(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getAllCustomers failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Collection<Transaction> getAllTransactions() {
        List<Transaction> result = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) result.add(mapTransaction(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getAllTransactions failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Collection<Beneficiary> getAllBeneficiaries() {
        List<Beneficiary> result = new ArrayList<>();
        String sql = "SELECT * FROM beneficiaries";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) result.add(mapBeneficiary(rs));
        } catch (SQLException e) {
            System.err.println("[DB] getAllBeneficiaries failed: " + e.getMessage());
        }
        return result;
    }

    // ================================================================
    //  ResultSet -> Entity mappers
    // ================================================================

    private Customer mapCustomer(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("contact")
        );
    }

    private Account mapAccount(ResultSet rs) throws SQLException {
        return new Account(
                rs.getInt("account_id"),
                rs.getInt("customer_id"),
                rs.getString("type"),
                rs.getDouble("balance")
        );
    }

    private Transaction mapTransaction(ResultSet rs) throws SQLException {
        Timestamp ts = rs.getTimestamp("timestamp");
        LocalDateTime ldt = (ts != null) ? ts.toLocalDateTime() : LocalDateTime.now();
        Transaction t = new Transaction(
                rs.getInt("account_id"),
                rs.getString("type"),
                rs.getDouble("amount")
        );
        t.setTransactionID(rs.getInt("transaction_id"));
        t.setTimestamp(ldt);
        return t;
    }

    private Beneficiary mapBeneficiary(ResultSet rs) throws SQLException {
        return new Beneficiary(
                rs.getInt("beneficiary_id"),
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("account_number"),
                rs.getString("bank_details")
        );
    }
}