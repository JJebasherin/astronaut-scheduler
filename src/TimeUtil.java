package src;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeUtil {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("HH:mm");

    public static LocalTime parse(String time) {
        try {
            return LocalTime.parse(time, F);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm (e.g., 09:30).");
        }
    }
}