import java.util.HashMap;
import java.util.Scanner;

public class InventoryStockTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap to store item name and quantity
        HashMap<String, Integer> inventory = new HashMap<>();

        int choice;

        do {

            System.out.println("\n===== Inventory Stock Tracker =====");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Quantity");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    String item = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    inventory.put(item, qty);

                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.print("Enter item name to update: ");
                    String updateItem = sc.nextLine();

                    if (inventory.containsKey(updateItem)) {

                        System.out.print("Enter quantity to add/remove: ");
                        int change = sc.nextInt();

                        int newQty = inventory.get(updateItem) + change;

                        inventory.put(updateItem, newQty);

                        System.out.println("Stock updated.");
                    } else {
                        System.out.println("Item not found.");
                    }

                    break;

                case 3:

                    System.out.println("\nCurrent Inventory:");

                    for (String key : inventory.keySet()) {
                        System.out.println(key + " : " + inventory.get(key));
                    }

                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}