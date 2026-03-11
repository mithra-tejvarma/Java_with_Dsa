import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Student class
class Student {
    int id;
    String name;
    int age;
    String department;

    Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Department: " + department);
    }
}

public class StudentDatabaseLookupSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap to store student ID -> Student object
        HashMap<Integer, Student> database = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT DATABASE LOOKUP SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (database.containsKey(id)) {
                        System.out.println("Student with this ID already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    database.put(id, new Student(id, name, age, department));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    if (database.containsKey(searchId)) {
                        System.out.println("\nStudent Found:");
                        database.get(searchId).displayDetails();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    if (database.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n===== ALL STUDENTS =====");
                        for (Map.Entry<Integer, Student> entry : database.entrySet()) {
                            entry.getValue().displayDetails();
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}