import java.util.*;

// Vehicle class
class Vehicle {
    String vehicleNumber;
    long entryTime;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = System.currentTimeMillis(); // record entry time
    }
}

// ParkingLot class
class ParkingLot {

    int capacity;
    HashMap<String, Vehicle> parkedVehicles = new HashMap<>();

    ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    // Vehicle enters parking
    void parkVehicle(String vehicleNumber) {

        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking Full!");
            return;
        }

        if (parkedVehicles.containsKey(vehicleNumber)) {
            System.out.println("Vehicle already parked.");
            return;
        }

        Vehicle v = new Vehicle(vehicleNumber);
        parkedVehicles.put(vehicleNumber, v);

        System.out.println("Vehicle parked successfully.");
    }

    // Vehicle exits parking
    void removeVehicle(String vehicleNumber) {

        if (!parkedVehicles.containsKey(vehicleNumber)) {
            System.out.println("Vehicle not found.");
            return;
        }

        Vehicle v = parkedVehicles.get(vehicleNumber);

        long exitTime = System.currentTimeMillis();

        long parkedTime = (exitTime - v.entryTime) / 1000; // seconds

        int fee = (int) (parkedTime * 1); // ₹1 per second for demo

        parkedVehicles.remove(vehicleNumber);

        System.out.println("Vehicle removed.");
        System.out.println("Parking Time: " + parkedTime + " seconds");
        System.out.println("Parking Fee: ₹" + fee);
    }

    // Show parked vehicles
    void showVehicles() {

        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles parked.");
            return;
        }

        System.out.println("\nCurrently Parked Vehicles:");

        for (String number : parkedVehicles.keySet()) {
            System.out.println("Vehicle Number: " + number);
        }
    }

    // Show available spaces
    void showAvailableSpaces() {
        System.out.println("Available Spaces: " + (capacity - parkedVehicles.size()));
    }
}

// Main class
public class ParkingLotSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingLot lot = new ParkingLot(5); // parking capacity

        int choice;

        do {

            System.out.println("\n===== PARKING LOT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Parked Vehicles");
            System.out.println("4. Show Available Spaces");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber = sc.nextLine();

                    lot.parkVehicle(vehicleNumber);
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    String removeNumber = sc.nextLine();

                    lot.removeVehicle(removeNumber);
                    break;

                case 3:
                    lot.showVehicles();
                    break;

                case 4:
                    lot.showAvailableSpaces();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}