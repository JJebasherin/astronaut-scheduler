package src;

import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance = null;

    private final List<Task> tasks = new ArrayList<>();

    private ScheduleManager() {}

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) instance = new ScheduleManager();
        return instance;
    }

    public synchronized void addTask(Task newTask) throws TaskConflictException {
        for (Task existing : tasks) {
            if (overlaps(existing, newTask)) {
                throw new TaskConflictException(
                    "Error: Task conflicts with existing task \"" + existing.getDescription() + "\"."
                );
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStart));
    }

    public synchronized boolean removeTask(String description) {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            if (t.getDescription().equalsIgnoreCase(description)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public synchronized List<Task> viewTasksSorted() {
        List<Task> copy = new ArrayList<>(tasks);
        copy.sort(Comparator.comparing(Task::getStart));
        return copy;
    }

    private boolean overlaps(Task a, Task b) {
        return a.getStart().isBefore(b.getEnd()) && b.getStart().isBefore(a.getEnd());
    }

    public synchronized boolean isEmpty() {
        return tasks.isEmpty();
    }
}
