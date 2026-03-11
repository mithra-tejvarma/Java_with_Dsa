import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine().toLowerCase();

        // Remove punctuation
        text = text.replaceAll("[^a-z0-9 ]", "");

        // Split into words
        String[] words = text.split("\\s+");

        // HashMap to store word frequency
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {

            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        System.out.println("\nWord Frequencies:");

        for (String word : frequencyMap.keySet()) {
            System.out.println(word + " -> " + frequencyMap.get(word));
        }

        sc.close();
    }
}