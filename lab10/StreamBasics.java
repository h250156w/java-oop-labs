package lab10;

import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {
        List<String> names = List.of("Tariro", "Bob", "Farai", "An", "Nyasha", "Kuda", "Jo");

        List<String> processedNames = names.stream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Original Names: " + names);
        System.out.println("Filtered (>3 chars), Uppercased, and Sorted: " + processedNames);
    }
}
