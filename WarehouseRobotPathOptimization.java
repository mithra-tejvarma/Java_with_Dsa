import java.util.Scanner;

public class WarehouseRobotPathOptimization {

    // Function to find minimum path cost
    static int minPathCost(int[][] grid, int rows, int cols) {

        int[][] dp = new int[rows][cols];

        // Starting cell
        dp[0][0] = grid[0][0];

        // Fill first row
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter warehouse grid costs:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter cost for cell [" + i + "][" + j + "]: ");
                grid[i][j] = sc.nextInt();
            }
        }

        int result = minPathCost(grid, rows, cols);

        System.out.println("\nMinimum cost for robot to reach destination: " + result);

        sc.close();
    }
}