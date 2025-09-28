package src;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ScheduleManager mgr = ScheduleManager.getInstance();
        Scanner sc = new Scanner(System.in);

        System.out.println("Astronaut Daily Schedule Organizer");

        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("\nChoose: 1=Add  2=Remove  3=View  4=Exit");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": // Add Task
                    try {
                        System.out.print("Description: ");
                        String desc = sc.nextLine().trim();
                        System.out.print("Start (HH:mm): ");
                        String start = sc.nextLine().trim();
                        System.out.print("End (HH:mm): ");
                        String end = sc.nextLine().trim();
                        System.out.print("Priority (High/Medium/Low): ");
                        String pr = sc.nextLine().trim();

                        Task t = TaskFactory.create(desc, start, end, pr);
                        mgr.addTask(t);
                        System.out.println("Task added successfully. No conflicts.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Invalid time format.");
                    } catch (TaskConflictException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2": // Remove Task
                    System.out.print("Enter task description to remove: ");
                    String removeDesc = sc.nextLine().trim();
                    if (mgr.removeTask(removeDesc)) {
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Error: Task not found.");
                    }
                    break;

                case "3": // View Tasks
                    if (mgr.isEmpty()) {
                        System.out.println("No tasks scheduled for the day.");
                    } else {
                        List<Task> tasks = mgr.viewTasksSorted();
                        char label = 'a';
                        for (Task t : tasks) {
                            System.out.println(label++ + ". " + t);
                        }
                    }
                    break;

                case "4":
                    exitRequested = true;
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
