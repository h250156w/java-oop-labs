package lab8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        List<String> rawNames = List.of("Tariro", "Kuda", "Tariro", "Farai", "Kuda", "Tendai");
        System.out.println("Raw List with duplicates: " + rawNames);

        Set<String> uniqueNames = new HashSet<>(rawNames);
        System.out.println("Set with duplicates removed: " + uniqueNames);
    }
}
