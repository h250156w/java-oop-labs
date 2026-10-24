package lab7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();
            System.out.print("Enter denominator: ");
            int den = sc.nextInt();
            System.out.println("Result: " + (num / den));
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        } finally {
            sc.close();
            System.out.println("Scanner closed successfully.");
        }
    }
}
