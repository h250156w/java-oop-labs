package lab7;

public class ArrayAccess {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.println("Element at index 2: " + numbers[2]);
            System.out.println("Element at index 10: " + numbers[10]); // Out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: Array index is out of bounds!");
        }
    }
}
