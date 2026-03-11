import java.util.HashSet;
import java.util.Scanner;

public class DuplicateTransactions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        int[] transactions = new int[n];

        // Input transactions
        for (int i = 0; i < n; i++) {
            System.out.print("Enter transaction ID " + (i + 1) + ": ");
            transactions[i] = sc.nextInt();
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        // Detect duplicates
        for (int i = 0; i < n; i++) {

            if (!seen.add(transactions[i])) {
                duplicates.add(transactions[i]);
            }
        }

        // Display result
        System.out.println("\n===== Duplicate Transaction Report =====");

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate transactions found.");
        } else {
            System.out.println("Duplicate Transaction IDs:");
            for (int id : duplicates) {
                System.out.println(id);
            }
        }

        sc.close();
    }
}