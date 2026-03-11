import java.util.Scanner;

public class StockProfitCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Input stock prices
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for Day " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
        }

        int minPrice = prices[0];
        int buyDay = 1;
        int sellDay = 1;
        int maxProfit = 0;
        int tempBuyDay = 1;

        // Find best buy/sell days
        for (int i = 1; i < n; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
                tempBuyDay = i + 1;
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
                buyDay = tempBuyDay;
                sellDay = i + 1;
            }
        }

        System.out.println("\n===== Stock Profit Report =====");

        if (maxProfit > 0) {
            System.out.println("Best Day to Buy: Day " + buyDay + " (Price: " + prices[buyDay - 1] + ")");
            System.out.println("Best Day to Sell: Day " + sellDay + " (Price: " + prices[sellDay - 1] + ")");
            System.out.println("Maximum Profit: " + maxProfit);
        } else {
            System.out.println("No profitable transaction possible.");
        }

        sc.close();
    }
}
