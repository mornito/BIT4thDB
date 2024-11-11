import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteFromTable {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. SQL query to delete a record
            String sqlDelete = "DELETE FROM users WHERE id = 1"; // Adjust table name and condition

            // 4. Execute the delete query
            int rowsAffected = statement.executeUpdate(sqlDelete);
            System.out.println("Rows deleted: " + rowsAffected);

            // 5. Close the statement and connection
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
