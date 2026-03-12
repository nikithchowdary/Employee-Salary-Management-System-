import java.util.ArrayList;
import java.util.Scanner;

class Employee {

    int id;
    String name;
    double basicSalary;
    double bonus;
    double deduction;

    Employee(int id, String name, double basicSalary, double bonus, double deduction) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deduction = deduction;
    }

    double calculateSalary() {
        return basicSalary + bonus - deduction;
    }

    void display() {
        System.out.println("\nEmployee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Deduction: " + deduction);
        System.out.println("Net Salary: " + calculateSalary());
    }
}

public class EmployeeSalaryManagement {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Employee Salary Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        System.out.print("Enter Deduction: ");
        double deduction = sc.nextDouble();

        Employee emp = new Employee(id, name, salary, bonus, deduction);
        employees.add(emp);

        System.out.println("Employee Added Successfully!");
    }

    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            e.display();
        }
    }

    static void searchEmployee() {

        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {
                e.display();
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    static void updateEmployee() {

        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {

                System.out.print("Enter new Basic Salary: ");
                e.basicSalary = sc.nextDouble();

                System.out.print("Enter new Bonus: ");
                e.bonus = sc.nextDouble();

                System.out.print("Enter new Deduction: ");
                e.deduction = sc.nextDouble();

                System.out.println("Employee salary updated!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {
                employees.remove(e);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}