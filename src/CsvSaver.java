import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CsvSaver {
    private final String delimiter = ",";
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;

    private final Path folder;

    public CsvSaver(Path folder){
        this.folder = folder;
    }

    //Member csv-saver
    public String toCsvMember(Member member) {
        return member.getName() + delimiter +
                member.getId() + delimiter +
                member.getBirthdate().format(dateFormat) + delimiter +
                member.getIsActive() + delimiter +
                member.getMissingPayments();
    }

    public void saveMember(List<Member> csvMemberData) throws IOException {
        Path file = folder.resolve("members.csv");
        Files.createDirectories(folder);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            //header så vi kan se hvilken data der er hvad:
            writer.write("name, id, birthdate, isActive, missingPayments");
            writer.newLine();

            for (Member member : csvMemberData) {
                writer.write(toCsvMember(member));
                writer.newLine();
            }
        }
    }


    //Coach csv-saver
    public String toCsvCoach(Coach coach) {
        String competitiveStudentId = "";
        if (coach.getStudents().isEmpty()) {
            competitiveStudentId = "empty";
        }
        else {
            for (CompetitiveMember competitiveMember : coach.getStudents()) {
                if (competitiveMember.equals(coach.getStudents().getFirst())) {
                    competitiveStudentId += competitiveMember.getId();
                } else {
                    competitiveStudentId += ";";
                    competitiveStudentId += competitiveMember.getId();
                }
            }
        }
        return coach.getName() + delimiter +
                coach.getId() + delimiter +
                competitiveStudentId;
    }


    public void saveCoach(List<Coach> coaches) throws IOException {
        Path file = folder.resolve("coaches.csv");   // csvFiles/coaches.csv
        Files.createDirectories(folder);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            writer.write("name, id, students");
            writer.newLine();

            for (Coach coach : coaches) {
                writer.write(toCsvCoach(coach));
                writer.newLine();
            }
        }
    }
}
