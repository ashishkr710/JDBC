import java.sql.*;

public class Table {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root";

        Connection con = null;
        try {

            Class.forName("java.sql.Driver");

            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO employee (empName,empSalary) VALUES ('Shivam',9999954)";
            int x=stmt.executeUpdate(sql);

            con.close();

            if(x>0)
                System.out.println("Insertion Successful");
            else
                System.out.println("Insertion Unsuccessful");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
