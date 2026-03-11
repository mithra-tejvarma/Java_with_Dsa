import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Ticket class
class Ticket {

    int ticketId;
    String customerName;
    String issue;

    Ticket(int id, String name, String issue) {
        this.ticketId = id;
        this.customerName = name;
        this.issue = issue;
    }
}

public class CustomerSupportSystem {

    static Queue<Ticket> ticketQueue = new LinkedList<>();
    static int ticketCounter = 1;

    // Create ticket
    public static void createTicket(String name, String issue) {

        Ticket ticket = new Ticket(ticketCounter++, name, issue);
        ticketQueue.add(ticket);

        System.out.println("Ticket created with ID: " + ticket.ticketId);
    }

    // Process ticket
    public static void resolveTicket() {

        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }

        Ticket ticket = ticketQueue.poll();

        System.out.println("Resolving Ticket ID: " + ticket.ticketId);
        System.out.println("Customer: " + ticket.customerName);
        System.out.println("Issue: " + ticket.issue);
    }

    // Show pending tickets
    public static void showTickets() {

        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }

        System.out.println("Pending Tickets:");

        for (Ticket t : ticketQueue) {
            System.out.println("ID: " + t.ticketId +
                    " | Customer: " + t.customerName +
                    " | Issue: " + t.issue);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Create Ticket");
            System.out.println("2. Resolve Ticket");
            System.out.println("3. View Pending Tickets");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Issue: ");
                    String issue = sc.nextLine();

                    createTicket(name, issue);
                    break;

                case 2:
                    resolveTicket();
                    break;

                case 3:
                    showTickets();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
