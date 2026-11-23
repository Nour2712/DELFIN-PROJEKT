import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SwimResult(int memberID, Discipline discipline, Duration time, LocalDate date)
        implements Comparable<SwimResult> {

    // Formaterer tiden som min:sek.millisek, fx 1:05.320
    public String resultFormat() {
        long minutes = time.toMinutes();
        long seconds = time.toSecondsPart();
        long millis = time.toMillisPart();
        return String.format("%d:%02d.%03d", minutes, seconds, millis);
    }

    @Override
    public int compareTo(SwimResult other) {
        return this.time.compareTo(other.time);
    }

    @Override
    public String toString() {
        String swimmer = (memberID == 0) ? "Ikke-medlem" : "Medlem ID " + memberID;
        return swimmer + ", " + discipline + ": " + resultFormat() + " (" + date + ")";
    }
}
