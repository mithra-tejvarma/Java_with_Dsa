import java.util.Scanner;
import java.util.Stack;

public class BrowserHistoryNavigation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        String currentPage = "Home";

        int choice;

        do {

            System.out.println("\n===== Browser Navigation =====");
            System.out.println("Current Page: " + currentPage);
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter page URL: ");
                    String newPage = sc.nextLine();

                    backStack.push(currentPage);
                    currentPage = newPage;

                    forwardStack.clear();

                    break;

                case 2:

                    if (!backStack.isEmpty()) {

                        forwardStack.push(currentPage);
                        currentPage = backStack.pop();

                    } else {
                        System.out.println("No previous page.");
                    }

                    break;

                case 3:

                    if (!forwardStack.isEmpty()) {

                        backStack.push(currentPage);
                        currentPage = forwardStack.pop();

                    } else {
                        System.out.println("No forward page.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting browser.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}