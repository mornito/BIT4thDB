import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "root";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. SQL query to update a record
            String sqlUpdate = "UPDATE users SET name = 'Anil Yadav', email = 'anil@anil.com' WHERE id = 1";

            // 4. Execute the update query
            int rowsAffected = statement.executeUpdate(sqlUpdate);
            System.out.println("Rows updated: " + rowsAffected);

            // 5. Close the statement and connection
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
