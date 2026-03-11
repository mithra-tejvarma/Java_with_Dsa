import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing a print job
class PrintJob {
    String documentName;

    PrintJob(String name) {
        this.documentName = name;
    }
}

public class PrinterJobScheduler {

    static Queue<PrintJob> printQueue = new LinkedList<>();

    // Add print job
    public static void addJob(String name) {
        PrintJob job = new PrintJob(name);
        printQueue.add(job);
        System.out.println("Added print job: " + name);
    }

    // Process next job
    public static void printJob() {
        if (printQueue.isEmpty()) {
            System.out.println("No print jobs in queue.");
            return;
        }

        PrintJob job = printQueue.poll();
        System.out.println("Printing: " + job.documentName);
    }

    // Display jobs in queue
    public static void showQueue() {
        if (printQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Print Queue:");
        for (PrintJob job : printQueue) {
            System.out.println(job.documentName);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Print Job");
            System.out.println("2. Print Next Job");
            System.out.println("3. Show Queue");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter document name: ");
                    String doc = sc.nextLine();
                    addJob(doc);
                    break;

                case 2:
                    printJob();
                    break;

                case 3:
                    showQueue();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}