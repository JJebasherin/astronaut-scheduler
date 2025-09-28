package src;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskFactory {

    public static Task create(String description, String startStr, String endStr, String priorityStr) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime start = LocalTime.parse(startStr, fmt);
            LocalTime end = LocalTime.parse(endStr, fmt);

            if (!start.isBefore(end)) {
                throw new IllegalArgumentException("Error: Invalid time format.");
            }

            Priority p = Priority.fromString(priorityStr);
            return new Task(description, start, end, p);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
    }
}
