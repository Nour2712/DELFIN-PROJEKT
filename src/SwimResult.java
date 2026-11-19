import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SwimResult (
        int memberID,
        Discipline discipline,
        LocalDate date,
        Duration time) implements Comparable<SwimResult> {


    public SwimResult(int memberID, Discipline discipline, Duration time, LocalDate date) {
        this(memberID, discipline, date, time);
    }

    public DateTimeFormatter resultFormat(){
        long minutes = time.toMinutes();
        long seconds = time.toSeconds();
        long millis = time.toMillis();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(minutes + ":" + seconds + ":" + millis + ":");
        return format;
    }

    /*
    @Override
    public String toString() {
        String comp = competitionName != null ? " (" + competitionName + ")" : "";
        return discipline + ": " + resultFormat() + " den " + date + comp;
    }
     */

    @Override
    public int compareTo(SwimResult other) {
        return this.time.compareTo(other.time);
    }
}