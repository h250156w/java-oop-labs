package lab7;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is outside valid range (0-120).");
        }
        System.out.println("Valid age entered: " + age);
    }

    public static void main(String[] args) {
        try {
            validateAge(25);
            validateAge(150); // Triggers exception
        } catch (InvalidAgeException e) {
            System.out.println("Validation Caught: " + e.getMessage());
        }
    }
}
