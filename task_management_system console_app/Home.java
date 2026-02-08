import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Home {
    Map<Integer, Task> storage = new HashMap<Integer, Task>();
    static boolean isRun;
    int cmd;
    static {
        isRun = true;
    }

    public Home() {
        instruction();
    }

    void instruction() {
        System.out.println("=================Well come to STMS================");
        System.out.println("Press 0: Display Menu's");
        System.out.println("Press 1: Add new task");
        System.out.println("Press 2: Update task status");
        System.out.println("Press 3: Display All Task");
        System.out.println("Press 4: Delete a task");
        System.out.println("Press 5: To Exit");
        System.out.println("Press 6: To clear Terminal");
        System.out.println("===================================================");
    }

    void readCmd() {
        System.out.print("Enter a valid Command: ");
        Scanner scan = new Scanner(System.in);
        cmd = scan.nextInt();
        operation(cmd);
    }

    void operation(int cmd) {
        switch (cmd) {
            case 0:
                instruction();
                break;
            case 1:
                newTask();
                break;
            case 2:
                changeStatus();
                break;
            case 3:
                displayTasks();
                break;
            case 4:
                delete();
                break;
            case 5:
                isRun = false;
                break;
            case 6:
                try {
                    clear();
                } catch (InterruptedException | IOException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid Command");
                break;
        }
    }

    void newTask() {
        Task task = new Task();
        Scanner scan = new Scanner(System.in);
        System.out.print("Task ID: ");
        task.setId(scan.nextInt());
        scan.nextLine();
        System.out.print("Task Title: ");
        task.setTitle(scan.nextLine());
        System.out.print("Task Description: ");
        task.setDescription(scan.nextLine());
        task.setStatus(Status.PENDING);

        storage.put(task.getId(), task);
    }

    void displayTasks() {
    System.out.println("==============================================================");
    System.out.printf("%-6s %-15s %-20s %-30s%n", "TID", "Status", "Title", "Description");
    System.out.println("==============================================================");

    for (Task task : storage.values()) {
        System.out.printf(
            "%-6d %-15s %-20s %-30s%n",
            task.getId(),
            task.getStatus().getDescription(),
            task.getTitle(),
            task.getDescription()
        );
    }

    System.out.println("==============================================================");
}

    void delete() {
        System.out.print("Enter the TID: ");
        Scanner scan = new Scanner(System.in);
        storage.remove(scan.nextInt());
    }

    void clear() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();
    }

    void changeStatus() {
        System.out.print("Task ID: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        System.out.println("Current Status: " + storage.get(id).getStatus());
        System.out.println("Press 1: Pending, Press 2: In - Progress , Press 3: Done");

        int temp = scan.nextInt();
        if (temp == 1)
            storage.get(id).setStatus(Status.PENDING);
        else if (temp == 2)
            storage.get(id).setStatus(Status.IN_PROGRESS);
        else
            storage.get(id).setStatus(Status.DONE);
    }
}
