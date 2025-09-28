package src;

import java.time.LocalTime;

public class Task {
    private final String description;
    private final LocalTime start;
    private final LocalTime end;
    private final Priority priority;

    public Task(String description, LocalTime start, LocalTime end, Priority priority) {
        this.description = description;
        this.start = start;
        this.end = end;
        this.priority = priority;
    }

    public String getDescription() { return description; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public Priority getPriority() { return priority; }

    @Override
    public String toString() {
        return start + " - " + end + ": " + description + " [" + priority + "]";
    }
}
