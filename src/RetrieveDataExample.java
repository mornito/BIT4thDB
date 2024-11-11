// Java Program to retrieve data from a ResultSet in JDBC 
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

// Driver Class 
public class RetrieveDataExample { 
	// Main Function 
	public static void main(String[] args) { 
		try { 
			// Load the MySQL JDBC driver 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			// Establish a connection to the database 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
			
			if (con != null) { 
				// Prepare the SQL query to select all records from the book table 
				String selectQuery = "SELECT * FROM book"; 
				PreparedStatement statement = con.prepareStatement(selectQuery); 
				
				// Execute the query and retrieve the result set 
				ResultSet resultSet = statement.executeQuery(); 
				System.out.println("The Available Data\n"); 
				
				// Iterate over the result set and print the retrieved data 
				while (resultSet.next()) { 
					int id = resultSet.getInt("id"); 
					String author_name = resultSet.getString("author"); 
					String book_name = resultSet.getString("name"); 
					String book_price = resultSet.getString("price"); 

					System.out.println("ID: " + id + ", Author_Name: " + author_name + ", Book_Name: "
									+ book_name + ", Book_Price "+book_price); 
				} 
			} else { 
				System.out.println("Not Connected..."); 
			} 
		} catch (Exception e) { 
			// Print any exceptions that occur during database access 
			System.out.println("Exception is " + e.getMessage()); 
		} 
	} 
} 
