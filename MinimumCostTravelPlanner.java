import java.util.Scanner;

public class MinimumCostTravelPlanner {

    // Function to find minimum travel cost
    static int minCost(int[] cost, int n) {

        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill DP table
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Minimum cost to reach last city
        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter travel cost for city " + (i + 1) + ": ");
            cost[i] = sc.nextInt();
        }

        int result = minCost(cost, n);

        System.out.println("\nMinimum travel cost to reach destination: " + result);

        sc.close();
    }
}