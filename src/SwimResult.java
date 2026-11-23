import java.time.Duration;
import java.time.format.DateTimeFormatter;

public record SwimResult(Discipline discipline, Duration time, Member member) {


    public DateTimeFormatter resultFormat(){
        long minutes = time.toMinutes();
        long seconds = time.toSeconds();
        long millis = time.toMillis();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(minutes + ":" + seconds + ":" + millis + ":");
        return format;
    }

    @Override
    public String toString() {
        String swimmer = member.getName();
        return swimmer + ", ved: " + discipline + ": " + resultFormat();
    }
}
