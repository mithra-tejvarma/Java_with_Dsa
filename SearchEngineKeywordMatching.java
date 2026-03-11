import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngineKeywordMatching {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // List of web page contents
        ArrayList<String> documents = new ArrayList<>();

        documents.add("Java programming tutorial");
        documents.add("Learn data structures and algorithms");
        documents.add("Best travel destinations in India");
        documents.add("Healthy food and fitness tips");
        documents.add("Introduction to machine learning");

        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        System.out.println("\nMatching Documents:");

        for (String doc : documents) {

            if (doc.toLowerCase().contains(keyword)) {

                System.out.println(doc);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching documents found.");
        }

        sc.close();
    }
}