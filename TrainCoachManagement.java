import java.util.LinkedList;
import java.util.Scanner;

public class TrainCoachManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LinkedList to store coach names
        LinkedList<String> coaches = new LinkedList<>();

        int choice;

        do {

            System.out.println("\n===== Train Coach Management System =====");
            System.out.println("1. Add Coach");
            System.out.println("2. Remove Coach");
            System.out.println("3. Display Coaches");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter coach name: ");
                    String coach = sc.nextLine();

                    coaches.add(coach);

                    System.out.println("Coach added to train.");
                    break;

                case 2:
                    System.out.print("Enter coach name to remove: ");
                    String removeCoach = sc.nextLine();

                    if (coaches.remove(removeCoach)) {
                        System.out.println("Coach removed.");
                    } else {
                        System.out.println("Coach not found.");
                    }

                    break;

                case 3:

                    if (coaches.isEmpty()) {
                        System.out.println("No coaches in the train.");
                    } else {

                        System.out.println("\nCurrent Train Coaches:");

                        for (String c : coaches) {
                            System.out.println(c);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}