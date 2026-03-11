import java.util.HashMap;
import java.util.Scanner;

public class ChatMessageWordCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter chat message:");
        String message = sc.nextLine();

        // Convert to lowercase for consistent counting
        message = message.toLowerCase();

        // Split words by space
        String[] words = message.split(" ");

        // HashMap to store word and count
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {

            if (wordCount.containsKey(word)) {

                wordCount.put(word, wordCount.get(word) + 1);

            } else {

                wordCount.put(word, 1);

            }
        }

        System.out.println("\nWord Frequency:");

        for (String word : wordCount.keySet()) {

            System.out.println(word + " : " + wordCount.get(word));
        }

        sc.close();
    }
}