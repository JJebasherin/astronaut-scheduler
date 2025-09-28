package src;

public class ConsoleNotifier implements TaskObserver {
    @Override
    public void onTaskAdded(Task task) {
        System.out.println("[NOTIFY] Task added: " + task);
    }
    @Override
    public void onTaskRemoved(Task task) {
        System.out.println("[NOTIFY] Task removed: " + task);
    }
    @Override
    public void onConflict(Task newTask, Task existingTask) {
        System.out.println("[ALERT] Conflict: new " + newTask + " conflicts with " + existingTask);
    }
}