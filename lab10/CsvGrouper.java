package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Learner(String name, int rollNumber, double gpa) {
    public String getGradeBand() {
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        return "C";
    }
}

public class CsvGrouper {
    public static void main(String[] args) {
        List<Learner> learners = List.of(
            new Learner("Alice", 101, 3.9),
            new Learner("Kuda", 102, 3.2),
            new Learner("Lynn", 103, 2.5),
            new Learner("Ben", 104, 3.6),
            new Learner("Tariro", 105, 2.8)
        );

        Map<String, List<Learner>> grouped = learners.stream()
            .collect(Collectors.groupingBy(Learner::getGradeBand));

        grouped.forEach((band, list) -> {
            Path file = Path.of("Band_" + band + ".csv");
            List<String> csvLines = list.stream()
                .map(l -> l.name() + "," + l.rollNumber() + "," + l.gpa())
                .collect(Collectors.toList());

            try {
                Files.write(file, csvLines);
                System.out.println("Wrote Grade Band " + band + " (" + csvLines.size() + " records) to " + file);
            } catch (IOException e) {
                System.err.println("Failed to write CSV for band " + band + ": " + e.getMessage());
            }
        });
    }
}
