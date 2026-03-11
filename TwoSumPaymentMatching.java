import java.util.HashMap;
import java.util.Scanner;

public class TwoSumPaymentMatching {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();

        int[] payments = new int[n];

        // Input payments
        for (int i = 0; i < n; i++) {
            System.out.print("Enter payment amount " + (i + 1) + ": ");
            payments[i] = sc.nextInt();
        }

        System.out.print("Enter target amount: ");
        int target = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;

        // Two Sum Logic
        for (int i = 0; i < n; i++) {

            int complement = target - payments[i];

            if (map.containsKey(complement)) {

                System.out.println("\n===== Matching Payments Found =====");
                System.out.println("Payment 1: " + complement);
                System.out.println("Payment 2: " + payments[i]);
                System.out.println("Total: " + target);

                found = true;
                break;
            }

            map.put(payments[i], i);
        }

        if (!found) {
            System.out.println("\nNo two payments match the target amount.");
        }

        sc.close();
    }
}