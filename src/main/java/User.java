public class User {
    private String name;
    private TaskList tasklist;

    // Creating user with a unique name and an empty task list
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList(); // Every user has their own to-do list
    }

    // Get the users name, in case we forget.. ( just in case)
    public String getName() {
        return name;
    }

    // Add new task to the users to-do list
    public void addTask(Task task) {
        taskList.addTask(task); // Passing off to the task list
    }


}
