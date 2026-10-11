package TaskManager;
class TaskEngine {
    private Task head = null;
    private Action top = null;
    // Check whether task ID already exists
    public boolean containsId(int id) {
        Task current = head;
        while (current != null) {
            if (current.id == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Add task at the end of linked list
    public void add(Task task) {
        task.next = null;

        if (head == null) {
            head = task;
            return;
        }
        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = task;
    }
    // Delete task by ID
    public Task delete(int id) {
        if (head == null) {
            return null;
        }
        if (head.id == id) {
            Task removed = head;
            head = head.next;
            removed.next = null;
            return removed;
        }
        Task current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next == null) {
            return null;
        }
        Task removed = current.next;
        current.next = removed.next;
        removed.next = null;
        return removed;
    }
    // Linear search by title
    public Task linearSearch(String title) {
        Task current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    // Bubble sort by priority
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Task current = head;
            while (current.next != null) {
                if (current.priority > current.next.priority) {
                    int tempId = current.id;
                    String tempTitle = current.title;
                    int tempPriority = current.priority;
                    current.id = current.next.id;
                    current.title = current.next.title;
                    current.priority = current.next.priority;
                    current.next.id = tempId;
                    current.next.title = tempTitle;
                    current.next.priority = tempPriority;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    // Stack PUSH
    public void pushAction(String type, Task task) {
        Action action = new Action(type, task);
        action.next = top;
        top = action;
    }

    // Stack POP
    public Action popAction() {
        if (top == null) {
            return null;
        }

        Action action = top;
        top = top.next;
        action.next = null;

        return action;
    }

    // Stack PEEK
    public Action peekAction() {
        return top;
    }
    // Undo the last Add or Delete
    public void undo() {
        Action action = popAction();
        if (action == null) {
            System.out.println("No actions to undo!");
            return;
        }
        if (action.type.equals("ADD")) {
            delete(action.taskCopy.id);
        } else if (action.type.equals("DELETE")) {
            Task restored = new Task(
                action.taskCopy.id,
                action.taskCopy.title,
                action.taskCopy.priority
            );
            restored.next = head;
            head = restored;
        }
        System.out.println(
            "Undo successful! " + action.type + " action reversed."
        );
    }
    // Display all tasks
    public void display() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println();
        System.out.printf(
            "%-8s %-25s %-12s%n",
            "ID", "TASK TITLE", "PRIORITY"
        );
        System.out.println("-----------------------------------------------");
        Task current = head;
        while (current != null) {
            System.out.printf(
                "%-8d %-25s %-12s%n",
                current.id,
                current.title,
                getPriorityName(current.priority)
            );
            current = current.next;
        }
    }
    // Convert priority number into text
    public String getPriorityName(int priority) {
        if (priority == 1) {
            return "High";
        } else if (priority == 2) {
            return "Medium";
        } else {
            return "Low";
        }
    }
}