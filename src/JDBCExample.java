import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute a SQL query
            String sqlQuery = "SELECT id, name, email FROM users"; // Adjust table/column names as needed
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 4. Process the ResultSet
            while (resultSet.next()) {
                // Retrieve data by column names
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                // Print the results
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // 5. Close the connections
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
