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

    // To mark a task as completed
    public void markTaskAsCompleted(String description) {
        if (head == null) {  // Check if the task list is empty
            System.out.println("No tasks yet.");
            return;  // Exit early if no tasks are available
        }

        // Proceed only if there are tasks in the list
        Node temp = head;
        while (temp != null) {
            if (temp.task.getDescription().equals(description)) {
                temp.task.markAsCompleted();
                System.out.println("Task marked as completed");
                return;  // Exit after marking the task as completed
            }
            temp = temp.next;
        }

        // If we reach here, the task was not found
        System.out.println("Task with the description '" + description + "' not found.");
    }

    // Print out all tasks in the list with their status (Done or still around)
    public void printAllTasks() {
        if (head == null) {
            System.out.println("No tasks yet. Add some");
            return;
        }
        Node current = head;
        while (current != null) {
            current.task.printTask(); // Print task details
            current = current.next;
        }
    }

    // Inside Node class to create that linked list
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null; // Task all alone
        }
    }
    public boolean isEmpty() {
        return head == null;  // If head is null, the list is empty
    }
}
