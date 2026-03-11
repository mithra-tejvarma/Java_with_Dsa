import java.util.*;

// Employee class
class Employee {

    int empId;
    String name;
    double basicSalary;

    // Constructor
    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Calculate bonus (10% of salary)
    double calculateBonus() {
        return basicSalary * 0.10;
    }

    // Calculate total salary
    double calculateTotalSalary() {
        return basicSalary + calculateBonus();
    }

    // Display employee payroll
    void displayPayroll() {

        System.out.println("\nEmployee ID: " + empId);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: ₹" + basicSalary);
        System.out.println("Bonus: ₹" + calculateBonus());
        System.out.println("Total Salary: ₹" + calculateTotalSalary());
    }
}

// Payroll System class
class PayrollSystem {

    List<Employee> employees = new ArrayList<>();

    // Add employee
    void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Show payroll details
    void showPayroll() {

        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        for (Employee e : employees) {
            e.displayPayroll();
        }
    }
}

// Main class
public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayrollSystem system = new PayrollSystem();

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Payroll");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    system.addEmployee(new Employee(id, name, salary));
                    break;

                case 2:
                    system.showPayroll();
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 3);

        sc.close();
    }
}