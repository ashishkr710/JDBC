
import SUD.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

    public class arrayList {
        public static void main(String[] args) {
            ArrayList<String> Employee = new ArrayList<String>();
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;


            String url = "jdbc:mysql://localhost:3306/company";
            String username = "root";
            String password = "root";

            try {
                // Load the JDBC driver
                Class.forName("java.sql.Driver");

                // Establish a connection
                connection = DriverManager.getConnection(url, username, password);

                // Create a statement
                statement = connection.createStatement();

                // Execute the query
                resultSet = statement.executeQuery("SELECT * FROM employee");

                // Iterate through the result set and add each name to the ArrayList
                while (resultSet.next()) {
                    Employee.add(resultSet.getString(username));
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Print the contents of the ArrayList
            for (String name : Employee) {
                System.out.println(name);}
        }
    }
