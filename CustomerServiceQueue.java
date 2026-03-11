import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerServiceQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Queue to store customer names
        Queue<String> queue = new LinkedList<>();

        int choice;

        do {

            System.out.println("\n===== Customer Service Queue =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Waiting Customers");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    queue.add(name);

                    System.out.println(name + " added to queue.");
                    break;

                case 2:

                    if (!queue.isEmpty()) {

                        String served = queue.poll();

                        System.out.println(served + " has been served.");

                    } else {
                        System.out.println("No customers in queue.");
                    }

                    break;

                case 3:

                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {

                        System.out.println("\nWaiting Customers:");

                        for (String customer : queue) {
                            System.out.println(customer);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Closing customer service.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}