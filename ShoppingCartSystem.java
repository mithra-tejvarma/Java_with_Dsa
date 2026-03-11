import java.util.*;

// Product class represents each item
class Product {
    int id;
    String name;
    double price;

    // Constructor
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Display product details
    void displayProduct() {
        System.out.println("ID: " + id + " | Name: " + name + " | Price: ₹" + price);
    }
}

// Cart class handles cart operations
class Cart {
    List<Product> cartItems = new ArrayList<>();

    // Add product to cart
    void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.name + " added to cart.");
    }

    // Remove product from cart
    void removeProduct(int id) {
        for (Product p : cartItems) {
            if (p.id == id) {
                cartItems.remove(p);
                System.out.println("Product removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    // Show cart items
    void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nItems in Cart:");
        for (Product p : cartItems) {
            p.displayProduct();
        }
    }

    // Calculate total bill
    void calculateTotal() {
        double total = 0;

        for (Product p : cartItems) {
            total += p.price;
        }

        System.out.println("Total Bill: ₹" + total);
    }
}

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        // Store available products
        List<Product> storeProducts = new ArrayList<>();

        storeProducts.add(new Product(1, "Laptop", 55000));
        storeProducts.add(new Product(2, "Phone", 25000));
        storeProducts.add(new Product(3, "Headphones", 2000));
        storeProducts.add(new Product(4, "Keyboard", 1500));

        int choice;

        do {

            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Show Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Calculate Total Bill");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : storeProducts) {
                        p.displayProduct();
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int addId = sc.nextInt();

                    for (Product p : storeProducts) {
                        if (p.id == addId) {
                            cart.addProduct(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeProduct(removeId);
                    break;

                case 4:
                    cart.showCart();
                    break;

                case 5:
                    cart.calculateTotal();
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}