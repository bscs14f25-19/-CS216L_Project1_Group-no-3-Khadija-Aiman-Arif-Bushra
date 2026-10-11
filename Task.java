package TaskManager;

public class Task {
    int id;
    String title;
    int priority;
    Task next;

    public Task(int id, String title, int priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.next = null;
    }
}
