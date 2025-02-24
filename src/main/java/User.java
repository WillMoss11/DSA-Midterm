public class User {
    private String name;
    private TaskList tasklist;

    // Creating user with a unique name and an empty task list
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList(); // Every user has their own to-do list
    }
}
