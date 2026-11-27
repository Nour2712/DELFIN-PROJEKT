import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public class CsvLoader {
    private static final String delimiter = ";";
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;

    private final Path folder;

    public CsvLoader(Path folder){
        this.folder = folder;
    }



}
