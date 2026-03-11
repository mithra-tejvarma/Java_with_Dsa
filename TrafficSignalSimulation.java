import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Vehicle class
class Vehicle {
    int vehicleId;
    String vehicleType;

    Vehicle(int id, String type) {
        this.vehicleId = id;
        this.vehicleType = type;
    }
}

public class TrafficSignalSimulation {

    static Queue<Vehicle> vehicleQueue = new LinkedList<>();
    static int vehicleCounter = 1;
    static boolean greenSignal = false;

    // Add vehicle to queue
    public static void arriveVehicle(String type) {

        Vehicle v = new Vehicle(vehicleCounter++, type);
        vehicleQueue.add(v);

        System.out.println(type + " added to queue with ID: " + v.vehicleId);
    }

    // Change signal
    public static void changeSignal() {

        greenSignal = !greenSignal;

        if (greenSignal)
            System.out.println("Signal turned GREEN. Vehicles can pass.");
        else
            System.out.println("Signal turned RED. Vehicles must stop.");
    }

    // Allow vehicle to pass
    public static void passVehicle() {

        if (!greenSignal) {
            System.out.println("Signal is RED. Vehicles cannot move.");
            return;
        }

        if (vehicleQueue.isEmpty()) {
            System.out.println("No vehicles waiting.");
            return;
        }

        Vehicle v = vehicleQueue.poll();

        System.out.println("Vehicle Passed → ID: " + v.vehicleId +
                " | Type: " + v.vehicleType);
    }

    // Show queue
    public static void showQueue() {

        if (vehicleQueue.isEmpty()) {
            System.out.println("No vehicles waiting.");
            return;
        }

        System.out.println("Vehicles Waiting:");

        for (Vehicle v : vehicleQueue) {
            System.out.println("ID: " + v.vehicleId +
                    " | Type: " + v.vehicleType);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Vehicle Arrives");
            System.out.println("2. Change Signal");
            System.out.println("3. Pass Vehicle");
            System.out.println("4. Show Queue");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle type (Car/Bike/Bus): ");
                    String type = sc.nextLine();
                    arriveVehicle(type);
                    break;

                case 2:
                    changeSignal();
                    break;

                case 3:
                    passVehicle();
                    break;

                case 4:
                    showQueue();
                    break;

                case 5:
                    System.out.println("Simulation stopped.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
