import java.util.Scanner;
import java.util.Stack;

public class UndoRedoEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        String currentText = "";

        int choice;

        do {

            System.out.println("\n===== Undo/Redo Editor =====");
            System.out.println("Current Text: " + currentText);
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text: ");
                    String newText = sc.nextLine();

                    undoStack.push(currentText);
                    currentText += newText;

                    redoStack.clear();

                    break;

                case 2:

                    if (!undoStack.isEmpty()) {

                        redoStack.push(currentText);
                        currentText = undoStack.pop();

                    } else {
                        System.out.println("Nothing to undo.");
                    }

                    break;

                case 3:

                    if (!redoStack.isEmpty()) {

                        undoStack.push(currentText);
                        currentText = redoStack.pop();

                    } else {
                        System.out.println("Nothing to redo.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting editor.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}