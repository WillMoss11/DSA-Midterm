public class TaskList {
    private Node head;

    // Each task list starts with no tasks
    public TaskList() {
        head = null; // Empty list to start with
    }

    // Add new task to the list. Like adding new item to the "to-do" pile
    public void addTask(Task task) {
        Node newNode = new Node(task); // Wreap task in a node
        if (head == null) {
            head = newNode; // First task, so it's the new head of the list
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Go to the end of the list
            }
            current.next = newNode; // Add task at the end
        }
    }

    // Mark a task as completed. Crossing off the list
    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted(); // Mark it as done
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found!"); // In case the task don't exist
    }
}
