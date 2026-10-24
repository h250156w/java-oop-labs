package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 12, 18, 3, 25, 9));

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Original List: " + numbers);
        System.out.println("Sum of elements: " + sum);
        System.out.println("Maximum element: " + max);

        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);
    }
}
