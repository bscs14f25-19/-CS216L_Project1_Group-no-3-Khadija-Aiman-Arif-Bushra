package TaskManager;

// Represents one action stored in the undo stack
public class Action {
    String type;
    Task taskCopy;
    Action next;

    public Action(String type, Task task) {
        this.type = type;
        this.taskCopy = new Task(
            task.id, task.title, task.priority
        );
        this.next = null;
    }
}