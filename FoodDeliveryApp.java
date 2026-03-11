import java.util.*;

// Food Item class
class FoodItem {
    int id;
    String name;
    double price;

    FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void displayFood() {
        System.out.println("ID: " + id + " | " + name + " | Price: ₹" + price);
    }
}

// Restaurant class
class Restaurant {
    int restaurantId;
    String name;
    List<FoodItem> menu = new ArrayList<>();

    Restaurant(int restaurantId, String name) {
        this.restaurantId = restaurantId;
        this.name = name;
    }

    void addFoodItem(FoodItem item) {
        menu.add(item);
    }

    void showMenu() {
        System.out.println("\nMenu for " + name);
        for (FoodItem f : menu) {
            f.displayFood();
        }
    }
}

// Order class
class Order {
    int orderId;
    FoodItem item;
    String status;

    Order(int orderId, FoodItem item) {
        this.orderId = orderId;
        this.item = item;
        this.status = "Preparing";
    }

    void updateStatus(String newStatus) {
        status = newStatus;
    }

    void showOrder() {
        System.out.println("Order ID: " + orderId +
                " | Item: " + item.name +
                " | Price: ₹" + item.price +
                " | Status: " + status);
    }
}

// Main System
class FoodDeliverySystem {

    List<Restaurant> restaurants = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    int orderCounter = 1;

    void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    void showRestaurants() {
        for (Restaurant r : restaurants) {
            System.out.println("Restaurant ID: " + r.restaurantId + " | Name: " + r.name);
        }
    }

    Restaurant getRestaurant(int id) {
        for (Restaurant r : restaurants) {
            if (r.restaurantId == id) return r;
        }
        return null;
    }

    void placeOrder(FoodItem item) {
        Order order = new Order(orderCounter++, item);
        orders.add(order);
        System.out.println("Order placed successfully.");
        order.showOrder();
    }

    void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed.");
            return;
        }

        for (Order o : orders) {
            o.showOrder();
        }
    }

    void updateOrderStatus(int orderId, String status) {
        for (Order o : orders) {
            if (o.orderId == orderId) {
                o.updateStatus(status);
                System.out.println("Order status updated.");
                return;
            }
        }
        System.out.println("Order not found.");
    }
}

// Main class
public class FoodDeliveryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FoodDeliverySystem system = new FoodDeliverySystem();

        // Create restaurants
        Restaurant r1 = new Restaurant(1, "Pizza Palace");
        r1.addFoodItem(new FoodItem(1, "Margherita Pizza", 250));
        r1.addFoodItem(new FoodItem(2, "Veg Pizza", 300));

        Restaurant r2 = new Restaurant(2, "Burger Hub");
        r2.addFoodItem(new FoodItem(3, "Cheese Burger", 150));
        r2.addFoodItem(new FoodItem(4, "Veg Burger", 120));

        system.addRestaurant(r1);
        system.addRestaurant(r2);

        int choice;

        do {

            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
            System.out.println("1. Show Restaurants");
            System.out.println("2. Show Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Track Orders");
            System.out.println("5. Update Order Status");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    system.showRestaurants();
                    break;

                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    Restaurant r = system.getRestaurant(rid);

                    if (r != null)
                        r.showMenu();
                    else
                        System.out.println("Restaurant not found");
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int rId = sc.nextInt();

                    Restaurant res = system.getRestaurant(rId);

                    if (res == null) {
                        System.out.println("Restaurant not found.");
                        break;
                    }

                    res.showMenu();

                    System.out.print("Enter Food ID: ");
                    int foodId = sc.nextInt();

                    for (FoodItem f : res.menu) {
                        if (f.id == foodId) {
                            system.placeOrder(f);
                        }
                    }
                    break;

                case 4:
                    system.showOrders();
                    break;

                case 5:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new status (Preparing / Out for Delivery / Delivered): ");
                    String status = sc.nextLine();

                    system.updateOrderStatus(oid, status);
                    break;

                case 6:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        } while (choice != 6);

        sc.close();
    }
}