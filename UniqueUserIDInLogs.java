import java.util.Scanner;

public class UniqueUserIDInLogs {

    // Function to find unique user ID
    static int findUniqueUser(int[] logs) {
        int unique = 0;

        for (int id : logs) {
            unique ^= id;
        }

        return unique;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of log entries: ");
        int n = sc.nextInt();

        int[] logs = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter user ID for log " + (i + 1) + ": ");
            logs[i] = sc.nextInt();
        }

        int uniqueUser = findUniqueUser(logs);

        System.out.println("\nUnique User ID in logs: " + uniqueUser);

        sc.close();
    }
}