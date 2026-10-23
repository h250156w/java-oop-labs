package lab5;

public class Printer {
    public void print(int i) { System.out.println("Printing int: " + i); }
    public void print(double d) { System.out.println("Printing double: " + d); }
    public void print(String s) { System.out.println("Printing String: " + s); }
    public void print(int[] arr) { 
        System.out.print("Printing int array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(42);
        p.print(3.14);
        p.print("Polymorphism");
        p.print(new int[]{1, 2, 3});
    }
}