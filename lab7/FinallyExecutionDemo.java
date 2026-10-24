package lab7;

public class FinallyExecutionDemo {
    static int testFinally() {
        try {
            System.out.println("Inside try block. Preparing to return 1...");
            return 1;
        } finally {
            System.out.println("Inside finally block. Executed BEFORE method actually returns!");
        }
    }

    public static void main(String[] args) {
        int result = testFinally();
        System.out.println("Method returned: " + result);
    }
}
