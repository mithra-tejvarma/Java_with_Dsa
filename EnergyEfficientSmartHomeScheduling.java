import java.util.Scanner;

public class EnergyEfficientSmartHomeScheduling {

    // Function to find maximum utility within energy budget
    static int maximizeUtility(int[] energy, int[] utility, int n, int maxEnergy) {

        int[][] dp = new int[n + 1][maxEnergy + 1];

        for (int i = 1; i <= n; i++) {
            for (int e = 0; e <= maxEnergy; e++) {

                // Do not include current appliance
                dp[i][e] = dp[i - 1][e];

                // Include current appliance if possible
                if (energy[i - 1] <= e) {
                    dp[i][e] = Math.max(
                            dp[i][e],
                            utility[i - 1] + dp[i - 1][e - energy[i - 1]]
                    );
                }
            }
        }

        return dp[n][maxEnergy];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of appliances: ");
        int n = sc.nextInt();

        sc.nextLine();

        String[] applianceNames = new String[n];
        int[] energy = new int[n];
        int[] utility = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nAppliance " + (i + 1));
            System.out.print("Enter appliance name: ");
            applianceNames[i] = sc.nextLine();

            System.out.print("Enter energy required: ");
            energy[i] = sc.nextInt();

            System.out.print("Enter utility/importance value: ");
            utility[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.print("\nEnter maximum available energy: ");
        int maxEnergy = sc.nextInt();

        int result = maximizeUtility(energy, utility, n, maxEnergy);

        System.out.println("\nMaximum utility achievable: " + result);

        sc.close();
    }
}