import java.util.Scanner;

public class OptimalInvestmentStrategy {

    // Function to find maximum profit using DP
    static int maxProfit(int[] cost, int[] profit, int n, int budget) {

        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= budget; b++) {

                // Do not take current investment
                dp[i][b] = dp[i - 1][b];

                // Take current investment if budget allows
                if (cost[i - 1] <= b) {
                    dp[i][b] = Math.max(
                            dp[i][b],
                            profit[i - 1] + dp[i - 1][b - cost[i - 1]]
                    );
                }
            }
        }

        return dp[n][budget];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of investment options: ");
        int n = sc.nextInt();

        int[] cost = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nInvestment " + (i + 1));
            System.out.print("Enter investment cost: ");
            cost[i] = sc.nextInt();

            System.out.print("Enter expected profit: ");
            profit[i] = sc.nextInt();
        }

        System.out.print("\nEnter total investment budget: ");
        int budget = sc.nextInt();

        int result = maxProfit(cost, profit, n, budget);

        System.out.println("\nMaximum profit possible: " + result);

        sc.close();
    }
}