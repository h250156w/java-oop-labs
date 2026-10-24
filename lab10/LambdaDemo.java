package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(12, 5, 20, 8, 15, 3, 30));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Function<Integer, String> formatter = n -> "Value: " + n;
        Consumer<String> printer = System.out::println;

        System.out.println("Original Numbers: " + numbers);

        numbers.removeIf(n -> !isEven.test(n));
        System.out.println("Even Numbers Only: " + numbers);

        for (Integer num : numbers) {
            printer.accept(formatter.apply(num));
        }
    }
}
