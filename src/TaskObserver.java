package src;
public interface TaskObserver {
    void onTaskAdded(Task task);
    void onTaskRemoved(Task task);
    void onConflict(Task newTask, Task existingTask);
}


