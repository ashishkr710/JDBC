import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

    public class arrayList {
        public static void main(String[] args) {
            ArrayList<Employee> Employee = new ArrayList<>();
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;


            String url = "jdbc:mysql://localhost:3306/company";
            String username = "root";
            String password = "root";

            try {
                Class.forName("java.sql.Driver");

                connection = DriverManager.getConnection(url, username, password);

                statement = connection.createStatement();

                resultSet = statement.executeQuery("SELECT * FROM employee");

                while (resultSet.next()) {
//                    Employee.add(resultSet.getString("empName"));;
                    int id = resultSet.getInt("empId");
                    String name = resultSet.getString("empName");
                    int salary = resultSet.getInt("empSalary");
                    // Add the employee object to the ArrayList
                    Employee.add(new Employee(id,name,salary));
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

            for (arrayList.Employee name : Employee) {
                System.out.println(name);}
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
    }
