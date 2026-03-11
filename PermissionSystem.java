import java.util.Scanner;

public class PermissionSystem {

    static final int READ = 4;     // 100
    static final int WRITE = 2;    // 010
    static final int EXECUTE = 1;  // 001

    // Display current permissions
    static void showPermissions(int permission) {
        System.out.println("\nCurrent Permission Value: " + permission);
        System.out.println("Read    : " + ((permission & READ) != 0 ? "YES" : "NO"));
        System.out.println("Write   : " + ((permission & WRITE) != 0 ? "YES" : "NO"));
        System.out.println("Execute : " + ((permission & EXECUTE) != 0 ? "YES" : "NO"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int permission = 0;
        int choice;

        do {
            System.out.println("\n===== PERMISSION SYSTEM =====");
            System.out.println("1. Grant Read Permission");
            System.out.println("2. Grant Write Permission");
            System.out.println("3. Grant Execute Permission");
            System.out.println("4. Remove Read Permission");
            System.out.println("5. Remove Write Permission");
            System.out.println("6. Remove Execute Permission");
            System.out.println("7. Show Permissions");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    permission = permission | READ;
                    System.out.println("Read permission granted.");
                    break;

                case 2:
                    permission = permission | WRITE;
                    System.out.println("Write permission granted.");
                    break;

                case 3:
                    permission = permission | EXECUTE;
                    System.out.println("Execute permission granted.");
                    break;

                case 4:
                    permission = permission & (~READ);
                    System.out.println("Read permission removed.");
                    break;

                case 5:
                    permission = permission & (~WRITE);
                    System.out.println("Write permission removed.");
                    break;

                case 6:
                    permission = permission & (~EXECUTE);
                    System.out.println("Execute permission removed.");
                    break;

                case 7:
                    showPermissions(permission);
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}