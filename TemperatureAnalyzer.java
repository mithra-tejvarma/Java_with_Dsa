import java.util.Scanner;

public class TemperatureAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] temp = new int[n];

        // Input temperatures
        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ": ");
            temp[i] = sc.nextInt();
        }

        // Assume first value as hottest and coldest
        int max = temp[0];
        int min = temp[0];
        int hottestDay = 1;
        int coldestDay = 1;

        int sum = 0;

        // Analyze temperatures
        for (int i = 0; i < n; i++) {

            sum += temp[i];

            if (temp[i] > max) {
                max = temp[i];
                hottestDay = i + 1;
            }

            if (temp[i] < min) {
                min = temp[i];
                coldestDay = i + 1;
            }
        }

        double avg = (double) sum / n;

        // Results
        System.out.println("\n===== Temperature Report =====");
        System.out.println("Hottest Day: Day " + hottestDay + " (" + max + "°C)");
        System.out.println("Coldest Day: Day " + coldestDay + " (" + min + "°C)");
        System.out.println("Average Temperature: " + avg + "°C");

        sc.close();
    }
}