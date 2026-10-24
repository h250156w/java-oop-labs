package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIoDemo {
    public static void main(String[] args) {
        Path filePath = Path.of("sample_output.txt");
        List<String> linesToWrite = List.of(
            "Header: Java OOP Lab Data",
            "Line 1: File I/O using java.nio.file",
            "Line 2: Demonstrating text persistence",
            "Line 3: Stream and Lambda processing"
        );

        try {
            Files.write(filePath, linesToWrite);
            System.out.println("Successfully wrote data to " + filePath.toAbsolutePath());

            List<String> readLines = Files.readAllLines(filePath);
            System.out.println("\n--- Reading Content From File ---");
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("File operation failed: " + e.getMessage());
        }
    }
}
