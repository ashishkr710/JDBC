import java.sql.*;

public class JDBCmethode {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Java";
        String username = "root";
        String password = "root";

//        uodate

        Connection con = null;
        try {

            Class.forName("java.sql.Driver");

            con = DriverManager.getConnection(url, username, password);


            Statement stmt = con.createStatement();


            int rowsUpdated = stmt.executeUpdate("UPDATE employee SET empName = 'Shivam' WHERE empId = '1222'");


            System.out.println(rowsUpdated + " rows updated");


//            DELETE

            String deleteSql = "DELETE FROM employee WHERE empId = 365";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {
                int rowsAffected = statement.executeUpdate(deleteSql);
                System.out.println(rowsAffected + " row(s) deleted");


            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

//            Search

            String selectSQL = "SELECT * FROM employee WHERE empId = 1222";
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stm = con.createStatement();

                 ResultSet rs = stm.executeQuery(selectSQL)) {
                while (rs.next()) {
                    // Retrieve values from ResultSet
                    int empId = rs.getInt("empId");
                    String empName = rs.getString("empName");

                    System.out.println(empId);
                    System.out.println(empName);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); }
    }
}
