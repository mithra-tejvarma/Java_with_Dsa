import java.util.LinkedList;
import java.util.Scanner;

public class SocialMediaFeed {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LinkedList to store posts
        LinkedList<String> feed = new LinkedList<>();

        int choice;

        do {

            System.out.println("\n===== Social Media Feed System =====");
            System.out.println("1. Add New Post");
            System.out.println("2. View Feed");
            System.out.println("3. Remove Post");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter post content: ");
                    String post = sc.nextLine();

                    // Add post at the beginning (latest post first)
                    feed.addFirst(post);

                    System.out.println("Post added to feed.");
                    break;

                case 2:

                    if (feed.isEmpty()) {
                        System.out.println("Feed is empty.");
                    } else {

                        System.out.println("\n--- Social Media Feed ---");

                        for (String p : feed) {
                            System.out.println(p);
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case 3:
                    System.out.print("Enter post content to remove: ");
                    String removePost = sc.nextLine();

                    if (feed.remove(removePost)) {
                        System.out.println("Post removed.");
                    } else {
                        System.out.println("Post not found.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting feed system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}