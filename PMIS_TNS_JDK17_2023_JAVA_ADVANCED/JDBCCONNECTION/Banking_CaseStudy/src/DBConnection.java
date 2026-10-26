import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton utility class that provides a shared JDBC Connection
 * to the banking_db MySQL database.
 *
 * Connection details:
 *   URL      : jdbc:mysql://localhost:3306/banking_db?useSSL=false&serverTimezone=UTC
 *   Username : root
 *   Password : (none)
 */
public class DBConnection {

    private static final String URL      = "jdbc:mysql://localhost:3306/banking_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Adarsh.A@2003";

    private static Connection connection = null;

    private DBConnection() {}

    /**
     * Returns the singleton Connection, creating it on first call.
     * Loads the MySQL JDBC driver class explicitly for compatibility.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("[DB] Connected to banking_db successfully.");
            } catch (ClassNotFoundException e) {
                System.err.println("[DB] MySQL JDBC Driver not found. Add mysql-connector-java.jar to classpath.");
                throw new RuntimeException(e);
            } catch (SQLException e) {
                System.err.println("[DB] Connection failed: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    /**
     * Closes the connection. Call this on application shutdown.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("[DB] Connection closed.");
            } catch (SQLException e) {
                System.err.println("[DB] Error closing connection: " + e.getMessage());
            }
        }
    }
}