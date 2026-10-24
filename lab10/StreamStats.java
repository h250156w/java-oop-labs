package lab10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Student(String name, double gpa) {}

public class StreamStats {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro", 3.8),
            new Student("Farai", 2.9),
            new Student("Rudo", 3.9),
            new Student("Kuda", 3.1),
            new Student("Tendai", 3.5)
        );

        double avgGpa = students.stream()
            .mapToDouble(Student::gpa)
            .average()
            .orElse(0.0);

        System.out.printf("Class Average GPA: %.2f%n", avgGpa);

        List<String> topPerformers = students.stream()
            .filter(s -> s.gpa() > avgGpa)
            .sorted(Comparator.comparing(Student::name))
            .map(Student::name)
            .collect(Collectors.toList());

        System.out.println("Above Average Students: " + topPerformers);
    }
}
