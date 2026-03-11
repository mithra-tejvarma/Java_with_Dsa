import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String currentPage = "Home";

    // Visit a new page
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        System.out.println("Visited: " + currentPage);
    }

    // Back button
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Back to: " + currentPage);
        } else {
            System.out.println("No pages in back history.");
        }
    }

    // Forward button
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Forward to: " + currentPage);
        } else {
            System.out.println("No pages in forward history.");
        }
    }

    // Show current page
    public void current() {
        System.out.println("Current Page: " + currentPage);
    }

    public static void main(String[] args) {

        BrowserHistory browser = new BrowserHistory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Visit Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current Page");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.visit(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.forward();
                    break;

                case 4:
                    browser.current();
                    break;

                case 5:
                    System.out.println("Exiting browser...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}