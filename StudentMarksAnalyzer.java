import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        int topperMarks = marks[0];
        int topperIndex = 0;
        int sum = 0;
        int passCount = 0;

        // Analyze marks
        for (int i = 0; i < n; i++) {

            sum += marks[i];

            if (marks[i] > topperMarks) {
                topperMarks = marks[i];
                topperIndex = i;
            }

            if (marks[i] >= 40) {
                passCount++;
            }
        }

        double average = (double) sum / n;
        double passPercentage = ((double) passCount / n) * 100;

        // Results
        System.out.println("\n===== Student Marks Report =====");
        System.out.println("Topper: Student " + (topperIndex + 1) + " with " + topperMarks + " marks");
        System.out.println("Average Marks: " + average);
        System.out.println("Pass Percentage: " + passPercentage + "%");

        sc.close();
    }
}