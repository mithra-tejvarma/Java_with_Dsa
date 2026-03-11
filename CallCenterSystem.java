import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Caller class
class Caller {

    int callerId;
    String name;
    String issue;

    Caller(int id, String name, String issue) {
        this.callerId = id;
        this.name = name;
        this.issue = issue;
    }
}

public class CallCenterSystem {

    static Queue<Caller> waitingQueue = new LinkedList<>();
    static int callerCounter = 1;

    // Add caller to queue
    public static void addCaller(String name, String issue) {

        Caller caller = new Caller(callerCounter++, name, issue);
        waitingQueue.add(caller);

        System.out.println("Caller added to queue. ID: " + caller.callerId);
    }

    // Attend next caller
    public static void attendCaller() {

        if (waitingQueue.isEmpty()) {
            System.out.println("No callers waiting.");
            return;
        }

        Caller caller = waitingQueue.poll();

        System.out.println("Attending Caller ID: " + caller.callerId);
        System.out.println("Name: " + caller.name);
        System.out.println("Issue: " + caller.issue);
    }

    // Display waiting callers
    public static void showQueue() {

        if (waitingQueue.isEmpty()) {
            System.out.println("No callers in queue.");
            return;
        }

        System.out.println("Waiting Callers:");

        for (Caller c : waitingQueue) {
            System.out.println("ID: " + c.callerId +
                    " | Name: " + c.name +
                    " | Issue: " + c.issue);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Caller");
            System.out.println("2. Attend Caller");
            System.out.println("3. View Waiting Callers");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter caller name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter issue: ");
                    String issue = sc.nextLine();

                    addCaller(name, issue);
                    break;

                case 2:
                    attendCaller();
                    break;

                case 3:
                    showQueue();
                    break;

                case 4:
                    System.out.println("Call center closed.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}