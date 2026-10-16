package lab2;

public class Predict {
    static {
        System.out.println("Static Block 1");
    }

    static {
        System.out.println("Static Block 2");
    }

    {
        System.out.println("Instance Block 1");
    }

    {
        System.out.println("Instance Block 2");
    }

    public Predict() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("--- First Object ---");
        new Predict();
        System.out.println("--- Second Object ---");
        new Predict();
    }
}
