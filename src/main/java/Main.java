import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[10]; // Just put a max of 10 users for example
        int userCount = 0; // Just to keep track of the users that are created

        boolean running = true;
        while (running) {
            // Main Menu start
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create a user");
            System.out.println("2. View all users");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Makes new line to make pretty

            switch (choice) {
                case 1:
                    // Create user function
                    if (userCount < users.length) {
                        System.out.print("Enter new user's name: ");
                        String userName = scanner.nextLine();
                        users[userCount] = new User(userName);
                        userCount++;
                        System.out.println("User " + userName + " created");
                    } else {
                        System.out.println("Users limit reached pal");
                    }
                    break;
                case 2:
                    // View all users function
                    System.out.println("\n--- All Users ---");
                    if (userCount == 0) {
                        System.out.println("No users created yet");
                    } else {
                        for (int i = 0; i < userCount; i++) {
                            System.out.println(users[i].getName());
                        }
                    }
                    // When viewing users, brings to user menu for selected user
                    System.out.print("\nEnter user name to manage tasks, or type 'back' to return to main menu: ");
                    String name = scanner.nextLine();
                    if (name.equalsIgnoreCase("back")) {
                        break;
                    }
                    User user = getUserByName(users, name, userCount);
                    if (user != null) {
                        userMenu(scanner, user);
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case 3:
                    // Exit function
                    running = false;
                    System.out.println("Godspeed Friend");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }

    // user by name mnethod
    private static User getUserByName(User[] users, String name, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;

    }
    // User menu scan
    private static void userMenu(Scanner scanner, User user) {
        boolean userRunning = true;
        while (userRunning) {
            System.out.println("\n--" + user.getName() + "'s Task Menu ---");
            System.out.println("1. Add a task");
            System.out.println("2. Mark task as completed");
            System.out.println("3. View all tasks");
            System.out.println("4. Return to main menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // pretty function

            switch (choice) {
                case 1:
                    // Add task function
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    user.addTask(new Task(taskDescription));
                    System.out.println("Task has been added");
                    break;
                case 2:
                    if (user.getTaskList().isEmpty()) {  // Check if there are any tasks first
                        System.out.println("No tasks yet");
                    } else {
                        System.out.print("Enter task description to mark as completed: ");
                        String taskToComplete = scanner.nextLine();
                        user.markTaskAsCompleted(taskToComplete);
                    }
                    break;
                case 3:
                    // View all users tasks
                    user.printAllTasks();
                    break;
                case 4:
                    // Return to maiin menu
                    userRunning = false;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
