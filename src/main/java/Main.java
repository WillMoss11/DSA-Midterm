import java.util.Scanner;

public class Main {
    public static void main(string[] args) {
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
                        System.out.println("User " + userName + " created!");
                    } else {
                        System.out.println("Users limit reached!");
                    }
                    break;
                case 2:
                    // View all users function
                    System.out.println("\n--- All Users ---");
                    if (userCount == 0) {
                        System.out.println("No users created yet!");
                    } else {
                        for (int i = 0; i < userCount; i++) {
                            System.out.println(users[i].getName());
                        }
                    }
            }
        }


    }
}
