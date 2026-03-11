import java.util.Scanner;

public class URLSlugGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter page title: ");
        String title = sc.nextLine();

        // Convert to lowercase
        String slug = title.toLowerCase();

        // Remove special characters
        slug = slug.replaceAll("[^a-z0-9 ]", "");

        // Replace spaces with hyphen
        slug = slug.replaceAll("\\s+", "-");

        System.out.println("Generated URL Slug: " + slug);

        sc.close();
    }
}