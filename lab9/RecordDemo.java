package lab9;

record StudentRecord(String name, int rollNumber, double gpa) {
    public StudentRecord {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        StudentRecord s1 = new StudentRecord("James", 101, 3.8);
        StudentRecord s2 = new StudentRecord("James", 101, 3.8);

        System.out.println("Student Details: " + s1);
        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 HashCode: " + s1.hashCode());
    }
}
