import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetGPT {
    public static void main(String[] args) {
        // Database URL, Username, and Password
        String jdbcUrl = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "";

        try {
            // 1. Establish a connection
            // Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", ""); 

            Class.forName("com.mysql.jdbc.Driver"); 

            // 2. Create a statement
            Statement statement = conn.createStatement();

            // 3. Execute a SQL query
            String sqlQuery = "SELECT id, name, email FROM users"; // Adjust table/column names as needed
            ResultSet rs = statement.executeQuery(sqlQuery);

            // 4. Process the ResultSet
            while (rs.next()) {
                // Retrieve data by column names
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Print the results
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // 5. Close the connections
            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
