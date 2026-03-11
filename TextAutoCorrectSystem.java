import java.util.ArrayList;
import java.util.Scanner;

public class TextAutoCorrectSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Dictionary words
        ArrayList<String> dictionary = new ArrayList<>();

        dictionary.add("hello");
        dictionary.add("world");
        dictionary.add("java");
        dictionary.add("programming");
        dictionary.add("computer");
        dictionary.add("science");
        dictionary.add("keyboard");
        dictionary.add("mobile");

        System.out.print("Enter word: ");
        String input = sc.nextLine().toLowerCase();

        boolean found = false;

        // Check if exact word exists
        for (String word : dictionary) {
            if (word.equals(input)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Word is correct.");
        } 
        else {

            System.out.println("Word not found. Suggestions:");

            // Suggest similar words
            for (String word : dictionary) {

                if (word.startsWith(input.substring(0, 1))) {
                    System.out.println(word);
                }
            }
        }

        sc.close();
    }
}