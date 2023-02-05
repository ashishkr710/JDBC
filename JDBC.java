import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");

            // Create a prepared statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)");

            // Set the values for the prepared statement
            stmt.setInt(1, 1);
            stmt.setString(2, "John Doe");
            stmt.setInt(3, 50000);

            // Execute the prepared statement
            stmt.executeUpdate();

            // Close the connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
