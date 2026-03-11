import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, String> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // accessOrder = true makes it work like LRU
        cache = new LinkedHashMap<Integer, String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    // Put key-value in cache
    public void put(int key, String value) {
        cache.put(key, value);
        System.out.println("Inserted: " + key + " -> " + value);
    }

    // Get value from cache
    public void get(int key) {
        if (cache.containsKey(key)) {
            System.out.println("Found: " + key + " -> " + cache.get(key));
        } else {
            System.out.println("Key not found in cache.");
        }
    }

    // Display cache contents
    public void display() {
        if (cache.isEmpty()) {
            System.out.println("Cache is empty.");
            return;
        }

        System.out.println("Current Cache State:");
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class CacheSystemSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache lru = new LRUCache(capacity);

        int choice;

        do {
            System.out.println("\n===== LRU CACHE SYSTEM =====");
            System.out.println("1. Put Data");
            System.out.println("2. Get Data");
            System.out.println("3. Display Cache");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter value: ");
                    String value = sc.nextLine();

                    lru.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key to access: ");
                    int getKey = sc.nextInt();
                    lru.get(getKey);
                    break;

                case 3:
                    lru.display();
                    break;

                case 4:
                    System.out.println("Exiting cache system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}