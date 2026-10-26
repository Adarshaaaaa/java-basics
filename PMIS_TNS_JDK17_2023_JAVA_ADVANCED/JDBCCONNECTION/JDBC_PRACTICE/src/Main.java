import java.sql.*;
class Main {
    public static void main(String[] args) {
        // Url
        String url = "jdbc:mysql://localhost:3306/jdbc";

        // Username
        String username = "root";
        String password = "Adarsh.A@2003";

        // Connection
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}