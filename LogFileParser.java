import java.util.ArrayList;
import java.util.HashMap;

public class LogFileParser {

    public static void main(String[] args) {

        // Sample log entries
        ArrayList<String> logs = new ArrayList<>();

        logs.add("INFO: Server started");
        logs.add("ERROR: Database connection failed");
        logs.add("WARNING: Disk space low");
        logs.add("ERROR: Database connection failed");
        logs.add("INFO: User logged in");
        logs.add("ERROR: File not found");

        // HashMap to store error frequency
        HashMap<String, Integer> errorCount = new HashMap<>();

        for (String log : logs) {

            if (log.startsWith("ERROR")) {

                if (errorCount.containsKey(log)) {

                    errorCount.put(log, errorCount.get(log) + 1);

                } else {

                    errorCount.put(log, 1);
                }
            }
        }

        System.out.println("Error Log Analysis:");

        for (String error : errorCount.keySet()) {

            System.out.println(error + " -> " + errorCount.get(error));
        }
    }
}