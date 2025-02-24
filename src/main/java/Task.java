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
}
