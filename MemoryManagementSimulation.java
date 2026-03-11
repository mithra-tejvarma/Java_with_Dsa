import java.util.HashMap;
import java.util.Scanner;

public class MemoryManagementSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap to store process name and memory size
        HashMap<String, Integer> memory = new HashMap<>();

        int totalMemory = 1000; // total memory units
        int usedMemory = 0;

        int choice;

        do {

            System.out.println("\n===== Memory Management System =====");
            System.out.println("Total Memory: " + totalMemory);
            System.out.println("Used Memory: " + usedMemory);
            System.out.println("Free Memory: " + (totalMemory - usedMemory));

            System.out.println("\n1. Allocate Memory");
            System.out.println("2. Free Memory");
            System.out.println("3. View Allocated Processes");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter process name: ");
                    String process = sc.nextLine();

                    System.out.print("Enter memory required: ");
                    int mem = sc.nextInt();

                    if (usedMemory + mem <= totalMemory) {

                        memory.put(process, mem);
                        usedMemory += mem;

                        System.out.println("Memory allocated to " + process);

                    } else {
                        System.out.println("Not enough memory available.");
                    }

                    break;

                case 2:
                    System.out.print("Enter process name to free memory: ");
                    String removeProcess = sc.nextLine();

                    if (memory.containsKey(removeProcess)) {

                        int freed = memory.remove(removeProcess);
                        usedMemory -= freed;

                        System.out.println("Memory freed from " + removeProcess);

                    } else {
                        System.out.println("Process not found.");
                    }

                    break;

                case 3:

                    if (memory.isEmpty()) {
                        System.out.println("No processes allocated.");
                    } else {

                        System.out.println("\nAllocated Processes:");

                        for (String key : memory.keySet()) {
                            System.out.println(key + " -> " + memory.get(key) + " units");
                        }
                    }

                    break;

                case 4:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}