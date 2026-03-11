import java.util.*;

// Driver class
class Driver {

    int driverId;
    String name;
    boolean isAvailable;

    // Constructor
    Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.isAvailable = true;
    }

    // Display driver details
    void displayDriver() {
        System.out.println("Driver ID: " + driverId +
                " | Name: " + name +
                " | Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Passenger class
class Passenger {

    int passengerId;
    String name;

    Passenger(int passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;
    }
}

// Ride Sharing System
class RideSharingSystem {

    List<Driver> drivers = new ArrayList<>();

    // Add driver
    void addDriver(Driver d) {
        drivers.add(d);
        System.out.println("Driver added successfully.");
    }

    // Show drivers
    void showDrivers() {

        if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }

        for (Driver d : drivers) {
            d.displayDriver();
        }
    }

    // Request ride
    void requestRide(Passenger p) {

        for (Driver d : drivers) {

            if (d.isAvailable) {

                System.out.println("\nRide Matched!");
                System.out.println("Passenger: " + p.name);
                System.out.println("Driver: " + d.name);

                d.isAvailable = false;
                return;
            }
        }

        System.out.println("No drivers available right now.");
    }
}

// Main class
public class RideSharingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RideSharingSystem system = new RideSharingSystem();

        int choice;

        do {

            System.out.println("\n===== RIDE SHARING SYSTEM =====");
            System.out.println("1. Add Driver");
            System.out.println("2. View Drivers");
            System.out.println("3. Request Ride");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Driver ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Driver Name: ");
                    String name = sc.nextLine();

                    system.addDriver(new Driver(id, name));
                    break;

                case 2:
                    system.showDrivers();
                    break;

                case 3:
                    System.out.print("Enter Passenger ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String pname = sc.nextLine();

                    Passenger p = new Passenger(pid, pname);

                    system.requestRide(p);
                    break;

                case 4:
                    System.out.println("Thank you for using Ride Sharing System.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}