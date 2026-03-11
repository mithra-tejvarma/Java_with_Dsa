import java.util.Scanner;

public class RotateAdvertisementDisplay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of advertisements: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] ads = new String[n];

        // Input advertisements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter advertisement " + (i + 1) + ": ");
            ads[i] = sc.nextLine();
        }

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        // Perform rotation
        for (int r = 0; r < k; r++) {

            String last = ads[n - 1];

            for (int i = n - 1; i > 0; i--) {
                ads[i] = ads[i - 1];
            }

            ads[0] = last;
        }

        // Display rotated ads
        System.out.println("\n===== Rotated Advertisement Display =====");

        for (int i = 0; i < n; i++) {
            System.out.println(ads[i]);
        }

        sc.close();
    }
}