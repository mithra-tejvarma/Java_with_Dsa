import java.util.ArrayList;
import java.util.Scanner;

public class SpamMessageDetector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // List of spam keywords
        ArrayList<String> spamWords = new ArrayList<>();

        spamWords.add("free");
        spamWords.add("win");
        spamWords.add("money");
        spamWords.add("prize");
        spamWords.add("offer");
        spamWords.add("lottery");

        System.out.println("Enter message:");
        String message = sc.nextLine().toLowerCase();

        boolean isSpam = false;

        // Check if message contains spam keywords
        for (String word : spamWords) {

            if (message.contains(word)) {

                System.out.println("Spam keyword detected: " + word);
                isSpam = true;
            }
        }

        if (isSpam) {
            System.out.println("This message is likely SPAM.");
        } else {
            System.out.println("Message looks safe.");
        }

        sc.close();
    }
}