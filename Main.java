import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        int choice = sc.nextInt();
        // Add employees to the ArrayList
        employeeList.add(new Employee(1, "Shivam", 35000));
        employeeList.add(new Employee(2, "Ritik", 75000));
        employeeList.add(new Employee(3, "Inam", 45000));
        employeeList.add(new Employee(4,"Gaurav",50000));

        // Display all employee details from the ArrayList
        for (Employee e : employeeList) {
            System.out.println("ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Salary: " + e.salary);
            System.out.println("------------------------------");
        }
    }
}
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
