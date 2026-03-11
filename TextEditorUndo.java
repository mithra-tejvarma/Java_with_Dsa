import java.util.Scanner;
import java.util.Stack;

public class TextEditorUndo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> history = new Stack<>();
        String currentText = "";

        int choice;

        do {

            System.out.println("\n===== Text Editor =====");
            System.out.println("Current Text: " + currentText);
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text to add: ");
                    String newText = sc.nextLine();

                    // Save current state before editing
                    history.push(currentText);

                    currentText = currentText + newText;

                    break;

                case 2:

                    if (!history.isEmpty()) {

                        currentText = history.pop();
                        System.out.println("Undo performed.");

                    } else {

                        System.out.println("Nothing to undo.");
                    }

                    break;

                case 3:
                    System.out.println("Closing editor.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}