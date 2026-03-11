import java.util.*;

// Student class
class Student {
    int studentId;
    String name;
    List<String> courses = new ArrayList<>();

    // Constructor
    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    // Enroll student in a course
    void enrollCourse(String courseName) {
        courses.add(courseName);
        System.out.println(name + " enrolled in " + courseName);
    }

    // Display student details
    void displayStudent() {
        System.out.println("Student ID: " + studentId + " | Name: " + name);
        System.out.println("Courses: " + courses);
    }
}

// Course class
class Course {
    int courseId;
    String courseName;

    // Constructor
    Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    void displayCourse() {
        System.out.println("Course ID: " + courseId + " | Course Name: " + courseName);
    }
}

// Registration system class
class RegistrationSystem {

    HashMap<Integer, Student> students = new HashMap<>();
    HashMap<Integer, Course> courses = new HashMap<>();

    // Add student
    void addStudent(int id, String name) {
        students.put(id, new Student(id, name));
        System.out.println("Student added successfully.");
    }

    // Add course
    void addCourse(int id, String name) {
        courses.put(id, new Course(id, name));
        System.out.println("Course added successfully.");
    }

    // Enroll student in course
    void enrollStudent(int studentId, int courseId) {

        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.enrollCourse(course.courseName);
    }

    // Show students
    void showStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students.values()) {
            s.displayStudent();
            System.out.println();
        }
    }

    // Show courses
    void showCourses() {

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses.values()) {
            c.displayCourse();
        }
    }
}

// Main class
public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Show Students");
            System.out.println("5. Show Courses");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();

                    system.addStudent(sid, sname);
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String cname = sc.nextLine();

                    system.addCourse(cid, cname);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int esid = sc.nextInt();

                    System.out.print("Enter Course ID: ");
                    int ecid = sc.nextInt();

                    system.enrollStudent(esid, ecid);
                    break;

                case 4:
                    system.showStudents();
                    break;

                case 5:
                    system.showCourses();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}