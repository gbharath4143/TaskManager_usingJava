import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Task " + (i + 1) + ": " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + task.getTitle());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task removedTask = tasks.remove(taskIndex);
            System.out.println("Task removed: " + removedTask.getTitle());
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    Task task = new Task(title, description, dueDate);
                    taskManager.addTask(task);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int completedTaskIndex = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.markTaskAsCompleted(completedTaskIndex - 1);
                    break;
                case 4:
                    System.out.print("Enter the index of the task to remove: ");
                    int removedTaskIndex = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.removeTask(removedTaskIndex - 1);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
