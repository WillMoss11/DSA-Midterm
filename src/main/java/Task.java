public class Task {
    private String description;
    private boolean isCompleted;

    // Creating a task with a description. Not completed yet
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // Still work in progress
    }

    // Description of the task to remember what it's about
    public String getDescription() {
        return description;
    }

    // Check if the tsak is completed, or if it's still waiting to be used
    public boolean isCompleted() {
        return isCompleted;
    }

    // Marks the task as completed. Finally, the task can now rest
    public void markAsCompleted() {
        this.isCompleted = true; // Done n dusted
    }

    // Print out the task description and whether it's completed or still hanging around
    public void printTask() {
        System.out.println(description + (isCompleted ? " (Completed) " : " (Pending) "));
    }
}
