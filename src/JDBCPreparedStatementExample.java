import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCPreparedStatementExample {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "root";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 2. Create a PreparedStatement for insert
            String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // 3. Set parameters for the insert query
            preparedStatement.setString(1, "Jane Doe");
            preparedStatement.setString(2, "jane.doe@example.com");

            // 4. Execute the insert query
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // 5. Create a PreparedStatement for update
            String updateQuery = "UPDATE users SET email = ? WHERE name = ?";
            preparedStatement = connection.prepareStatement(updateQuery);

            // 6. Set parameters for the update query
            preparedStatement.setString(1, "updated.email@example.com");
            preparedStatement.setString(2, "Jane Doe");

            // 7. Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);

            // 8. Close the PreparedStatement and connection
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
