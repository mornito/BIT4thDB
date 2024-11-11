import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCStatementExample {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute a SQL query (Insert example)
            String insertQuery = "INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println("Rows inserted: " + rowsInserted);

            // 4. Execute a SQL query (Update example)
            String updateQuery = "UPDATE users SET email = 'new.email@example.com' WHERE name = 'John Doe'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            System.out.println("Rows updated: " + rowsUpdated);

            // 5. Close the statement and connection
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
