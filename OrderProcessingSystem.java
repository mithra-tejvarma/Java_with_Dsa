import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Order class
class Order {

    int orderId;
    String customerName;
    String product;

    Order(int id, String name, String product) {
        this.orderId = id;
        this.customerName = name;
        this.product = product;
    }
}

public class OrderProcessingSystem {

    static Queue<Order> orderQueue = new LinkedList<>();
    static int orderCounter = 1;

    // Add new order
    public static void placeOrder(String customer, String product) {

        Order order = new Order(orderCounter++, customer, product);
        orderQueue.add(order);

        System.out.println("Order placed successfully. Order ID: " + order.orderId);
    }

    // Process order
    public static void processOrder() {

        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }

        Order order = orderQueue.poll();

        System.out.println("Processing Order ID: " + order.orderId);
        System.out.println("Customer: " + order.customerName);
        System.out.println("Product: " + order.product);
        System.out.println("Order completed.");
    }

    // Show pending orders
    public static void showOrders() {

        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }

        System.out.println("Pending Orders:");

        for (Order o : orderQueue) {
            System.out.println("ID: " + o.orderId +
                    " | Customer: " + o.customerName +
                    " | Product: " + o.product);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Place Order");
            System.out.println("2. Process Order");
            System.out.println("3. View Pending Orders");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter product name: ");
                    String product = sc.nextLine();

                    placeOrder(name, product);
                    break;

                case 2:
                    processOrder();
                    break;

                case 3:
                    showOrders();
                    break;

                case 4:
                    System.out.println("System exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}