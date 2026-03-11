import java.util.Scanner;

public class SalesDataAnalysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] productNames = new String[n];
        int[] sales = new int[n];

        // Input product details
        for (int i = 0; i < n; i++) {

            System.out.print("Enter product name " + (i + 1) + ": ");
            productNames[i] = sc.nextLine();

            System.out.print("Enter sales for " + productNames[i] + ": ");
            sales[i] = sc.nextInt();
            sc.nextLine();
        }

        int maxSales = sales[0];
        int bestProductIndex = 0;

        int totalSales = 0;

        // Analyze sales
        for (int i = 0; i < n; i++) {

            totalSales += sales[i];

            if (sales[i] > maxSales) {
                maxSales = sales[i];
                bestProductIndex = i;
            }
        }

        double averageSales = (double) totalSales / n;

        // Results
        System.out.println("\n===== Sales Analysis Report =====");
        System.out.println("Best Selling Product: " + productNames[bestProductIndex]);
        System.out.println("Sales: " + maxSales);
        System.out.println("Average Sales: " + averageSales);

        sc.close();
    }
}