package SUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Press 1 For Search");
        System.out.println("Press 2 For Add");
        System.out.println("Press 3 For Update");
        System.out.println("Press 4 For Delete");
        int choice = Integer.parseInt(br.readLine());

        switch (choice) {
            case 1 ->{
                //Search Employee
                System.out.println("Search");
                System.out.print("Enter Employee Id = ");
                int empId =Integer.parseInt(br.readLine());
                Employee ep = new Employee(empId);
                Connection con = Connect();
                String q = "SELECT * FROM employee  WHERE empId="+empId;
                Statement stmt = con.createStatement();
                ResultSet set = stmt.executeQuery(q);
                set.next();
                int id = set.getInt(1);
                String name = set.getString(2);
                int Salary = set.getInt(3);

                System.out.println("ID: "+id);
                System.out.println("name: "+name);
                System.out.println("Salary:"+Salary);
                con.close();
            }
            case 2 -> {
                //ADD New Employee
                System.out.println("ADD");
                System.out.print("Enter Employee Name = ");
                String name = br.readLine();
                System.out.print("Enter Employee Salary = ");
                int Salary = Integer.parseInt(br.readLine());
                Employee ep = new Employee(name, Salary);
                Connection con = Connect();
                String q = "INSERT INTO employee (empName,empSalary) VALUES (?,?)";
                PreparedStatement stmt = con.prepareStatement(q);
                stmt.setString(1, ep.getEmpName());
                stmt.setInt(2, ep.getEmpSalary());
                stmt.executeUpdate();
                System.out.println(ep);
                con.close();
            }
            case 3 ->{
                // Update Employee
                System.out.println("Update");
                System.out.print("Enter Employee Id to Update : ");
                int empId =Integer.parseInt(br.readLine());
                System.out.print("Enter Updated Employee Name : ");
                String empName = br.readLine();
                System.out.print("Enter Updated Employee Salary : ");
                int empSalary = Integer.parseInt(br.readLine());
                Employee ep = new Employee(empId,empName,empSalary);
                Connection con = Connect();
                String q = "update employee set empName = ?, empSalary = ? where empId = ?";
                PreparedStatement stmt = con.prepareStatement(q);
                stmt.setString(1, ep.getEmpName());
                stmt.setInt(2,ep.getEmpSalary());
                stmt.setInt(3,ep.getEmpId());
                int RowEffected = stmt.executeUpdate();
                System.out.println(ep);
                System.out.println(RowEffected + " rows updated");
                con.close();
            }
            case 4 ->{
                // Delete Employee
                    System.out.print("Enter Employee Id to Delete =");
                    int empId =Integer.parseInt(br.readLine());
                    Employee ep = new Employee(empId);
                    Connection con = Connect();
                    String q = "DELETE FROM employee WHERE empId=?";
                    PreparedStatement stmt = con.prepareStatement(q);
                    stmt.setInt(1, ep.getEmpId());
                    int RowEffected = stmt.executeUpdate();
                    System.out.println(ep);
                    System.out.println(RowEffected + " rows Deleted");
                    con.close();
            }
        }
    }
    public static class Employee{
    private int empId;
    private String empName;
    private int empSalary;
    public Employee(int empId, String empName, int empSalary) {
            this.empId = empId;
            this.empName = empName;
            this.empSalary = empSalary;
    }
    public Employee(String empName, int empSalary) {
            this.empName = empName;
            this.empSalary = empSalary;
    }
        public Employee() {
            super();
        }
        public Employee(int empId) {
            this.empId = empId;
        }
        public int getEmpId() {
            return empId;
        }
        public void setEmpId(int empId) {
            this.empId = empId;
        }
        public String getEmpName() {
            return empName;
        }
        public void setEmpName(String empName) {
            this.empName = empName;
        }
        public int getEmpSalary() {
            return empSalary;
        }
        public void setEmpSalary(int empSalary) {
            this.empSalary = empSalary;
        }
        @Override
        public String toString() {
            return "Employee[" +
                    "empId=" + empId +
                    ", empName='" + empName + '\'' +
                    ", empSalary=" + empSalary +
                    ']';
        }
    }
    public static Connection Connect(){
        Connection con;
        try {
            Class.forName("java.sql.Driver");

            String url = "jdbc:mysql://localhost:3306/company";
            String username = "root";
            String password = "root";

            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();} catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
