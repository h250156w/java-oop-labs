package lab8;

import java.util.Arrays;

public class GenericSorter {
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {42, 12, 89, 27, 5};
        bubbleSort(numbers);
        System.out.println("Sorted Integers: " + Arrays.toString(numbers));

        String[] names = {"Tendai", "Alice", "Kuda", "Bob"};
        bubbleSort(names);
        System.out.println("Sorted Strings: " + Arrays.toString(names));
    }
}
