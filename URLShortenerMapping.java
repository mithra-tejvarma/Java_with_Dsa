import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortenerMapping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // short URL -> original URL
        HashMap<String, String> urlMap = new HashMap<>();

        int counter = 1;
        int choice;

        do {
            System.out.println("\n===== URL SHORTENER SYSTEM =====");
            System.out.println("1. Shorten URL");
            System.out.println("2. Get Original URL");
            System.out.println("3. View All URL Mappings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter original URL: ");
                    String originalUrl = sc.nextLine();

                    String shortCode = "u" + counter;
                    counter++;

                    urlMap.put(shortCode, originalUrl);

                    System.out.println("Short URL created successfully.");
                    System.out.println("Short Code: " + shortCode);
                    break;

                case 2:
                    System.out.print("Enter short code: ");
                    String code = sc.nextLine();

                    if (urlMap.containsKey(code)) {
                        System.out.println("Original URL: " + urlMap.get(code));
                    } else {
                        System.out.println("Short code not found.");
                    }
                    break;

                case 3:
                    if (urlMap.isEmpty()) {
                        System.out.println("No URL mappings available.");
                    } else {
                        System.out.println("\n===== ALL URL MAPPINGS =====");
                        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}