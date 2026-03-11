import java.util.Scanner;

public class FeatureFlagSystem {

    static final int DARK_MODE = 1;       // 0001
    static final int NOTIFICATIONS = 2;   // 0010
    static final int LOCATION = 4;        // 0100
    static final int AUTO_SAVE = 8;       // 1000

    // Toggle a feature
    static int toggleFeature(int flags, int feature) {
        return flags ^ feature;
    }

    // Check if a feature is enabled
    static boolean isEnabled(int flags, int feature) {
        return (flags & feature) != 0;
    }

    // Display all feature states
    static void showFeatures(int flags) {
        System.out.println("\nCurrent Flag Value: " + flags);
        System.out.println("Dark Mode     : " + (isEnabled(flags, DARK_MODE) ? "ON" : "OFF"));
        System.out.println("Notifications : " + (isEnabled(flags, NOTIFICATIONS) ? "ON" : "OFF"));
        System.out.println("Location      : " + (isEnabled(flags, LOCATION) ? "ON" : "OFF"));
        System.out.println("Auto Save     : " + (isEnabled(flags, AUTO_SAVE) ? "ON" : "OFF"));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int flags = 0; // all features OFF initially
        int choice;

        do {
            System.out.println("\n===== FEATURE FLAG SYSTEM =====");
            System.out.println("1. Toggle Dark Mode");
            System.out.println("2. Toggle Notifications");
            System.out.println("3. Toggle Location");
            System.out.println("4. Toggle Auto Save");
            System.out.println("5. Show Feature States");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    flags = toggleFeature(flags, DARK_MODE);
                    System.out.println("Dark Mode toggled.");
                    break;

                case 2:
                    flags = toggleFeature(flags, NOTIFICATIONS);
                    System.out.println("Notifications toggled.");
                    break;

                case 3:
                    flags = toggleFeature(flags, LOCATION);
                    System.out.println("Location toggled.");
                    break;

                case 4:
                    flags = toggleFeature(flags, AUTO_SAVE);
                    System.out.println("Auto Save toggled.");
                    break;

                case 5:
                    showFeatures(flags);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}