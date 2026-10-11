package TaskManager;
import java.util.Scanner;
public class TaskManager {
    // Read and validate integer input
    private static int readInt(
            Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println(
                    "Invalid input. Enter a number from "
                    + min + " to " + max + "."
                );
            } catch (NumberFormatException e) {
                System.out.println(
                    "Please enter a valid whole number."
                );
            }
        }
    }
    public static void main(String[] args) {
        TaskEngine engine = new TaskEngine();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==================================");
            System.out.println("       KBA TASK MANAGER");
            System.out.println("==================================");
            System.out.println("1. Add New Task");
            System.out.println("2. Delete Task by ID");
            System.out.println("3. Search Task by Title");
            System.out.println("4. Sort Tasks by Priority");
            System.out.println("5. View All Tasks");
            System.out.println("6. Undo Last Add/Delete");
            System.out.println("7. View Last Stack Action (Peek)");
            System.out.println("8. Exit");
            System.out.println("==================================");
            int choice = readInt(
                sc, "Select option (1-8): ", 1, 8
            );
            switch (choice) {
                case 1: {
                    int id = readInt(
                        sc, "Enter task ID: ", 1, Integer.MAX_VALUE
                    );
                    if (engine.containsId(id)) {
                        System.out.println(
                            "This ID already exists. Use another ID."
                        );
                        break;
                    }

                    System.out.print("Enter task title: ");
                    String title = sc.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println(
                            "Title cannot be empty."
                        );
                        break;
                    }
                    int priority = readInt(
                        sc,
                        "Priority (1=High, 2=Medium, 3=Low): ",
                        1, 3
                    );
                    Task task = new Task(id, title, priority);
                    engine.add(task);
                    engine.pushAction("ADD", task);
                    System.out.println("Task added successfully!");
                    break;
                }
                case 2: {
                    int id = readInt(
                        sc, "Enter task ID to delete: ",
                        1, Integer.MAX_VALUE
                    );
                    Task removed = engine.delete(id);
                    if (removed != null) {
                        engine.pushAction("DELETE", removed);
                        System.out.println(
                            "Task deleted successfully!"
                        );
                    } else {
                        System.out.println("Task ID not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.print(
                        "Enter task title to search: "
                    );
                    String title = sc.nextLine().trim();
                    Task found = engine.linearSearch(title);
                    if (found != null) {
                        System.out.println("Task found!");
                        System.out.println("ID: " + found.id);
                        System.out.println("Title: " + found.title);
                        System.out.println(
                            "Priority: "
                            + engine.getPriorityName(found.priority)
                        );
                    } else {
                        System.out.println("Task not found.");
                    }

                    break;
                }
                case 4:
                    engine.bubbleSort();
                    System.out.println(
                        "Tasks sorted by priority!"
                    );
                    break;
                case 5:
                    engine.display();
                    break;
                case 6:
                    engine.undo();
                    break;
                case 7: {
                    Action last = engine.peekAction();
                    if (last == null) {
                        System.out.println(
                            "The action stack is empty."
                        );
                    } else {
                        System.out.println(
                            "Last action: " + last.type
                        );
                        System.out.println(
                            "Task ID: " + last.taskCopy.id
                        );
                        System.out.println(
                            "Task title: " + last.taskCopy.title
                        );
                        System.out.println(
                            "Peek does not remove the action."
                        );
                    }
                    break;
                }
                case 8:
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
            }
        }
    }
}