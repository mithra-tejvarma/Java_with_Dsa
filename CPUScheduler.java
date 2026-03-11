import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing a task
class Task {
    int taskId;
    String taskName;
    int burstTime; // CPU time required

    Task(int id, String name, int time) {
        this.taskId = id;
        this.taskName = name;
        this.burstTime = time;
    }
}

public class CPUScheduler {

    static Queue<Task> readyQueue = new LinkedList<>();
    static int taskCounter = 1;

    // Add task to queue
    public static void addTask(String name, int burstTime) {

        Task task = new Task(taskCounter++, name, burstTime);
        readyQueue.add(task);

        System.out.println("Task added: " + task.taskName + " (ID: " + task.taskId + ")");
    }

    // Execute next task
    public static void executeTask() {

        if (readyQueue.isEmpty()) {
            System.out.println("No tasks in queue.");
            return;
        }

        Task task = readyQueue.poll();

        System.out.println("Executing Task ID: " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("CPU Time Required: " + task.burstTime + " ms");
        System.out.println("Task completed.");
    }

    // Show pending tasks
    public static void showTasks() {

        if (readyQueue.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }

        System.out.println("Pending Tasks:");

        for (Task t : readyQueue) {
            System.out.println("ID: " + t.taskId +
                    " | Name: " + t.taskName +
                    " | Burst Time: " + t.burstTime + " ms");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Task");
            System.out.println("2. Execute Task");
            System.out.println("3. Show Pending Tasks");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter CPU burst time (ms): ");
                    int time = sc.nextInt();

                    addTask(name, time);
                    break;

                case 2:
                    executeTask();
                    break;

                case 3:
                    showTasks();
                    break;

                case 4:
                    System.out.println("Scheduler stopped.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}